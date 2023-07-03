package com.example.AppointmentBooking.utility;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import com.example.AppointmentBooking.entity.ScheduleEntity;
import com.example.AppointmentBooking.repository.AppointmentEntity;
import com.example.AppointmentBooking.uiRequest.BookAppointmentUiRequest;
import com.example.AppointmentBooking.uiRequest.ScheduleUiRequest;
import com.example.AppointmentBooking.uiResponse.SchedueUiResponse;


@Component
public class AppointmentHelper {
	
   
    private static CacheManager cacheManager;
    
    @Autowired
    public AppointmentHelper(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }


	public static AppointmentEntity convertFromUiRequest(BookAppointmentUiRequest req) {
		AppointmentEntity appointmentEntity= new AppointmentEntity();
		appointmentEntity.setAdditionalNotes(req.getAdditionalNotes());
	appointmentEntity.setBookingId(req.getBookingId());
	appointmentEntity.setDoctorId(req.getDoctorId());
	appointmentEntity.setPatientId(req.getPatientId());
	
	ScheduleEntity scheduleEntity= new ScheduleEntity();
		ScheduleUiRequest scheduleReq = req.getScheduleReq();
		scheduleEntity.setDate(scheduleReq.getDate());
		scheduleEntity.setStartTime(scheduleReq.getStartTime());
		scheduleEntity.setEndTime(scheduleReq.getEndTime());
		scheduleEntity.setDoctorId(appointmentEntity.getDoctorId());
		
		appointmentEntity.setSchedule(scheduleEntity);
		
		// TODO Auto-generated method stub
		return appointmentEntity;
	}

	public static List<SchedueUiResponse> convertToScheduleUiResponse(List<ScheduleEntity> doctorSchedule) {
		
		List<SchedueUiResponse> listOfScheduleUiResponse = new ArrayList<SchedueUiResponse>();
		
		for(ScheduleEntity schedule:doctorSchedule)
		{
			SchedueUiResponse schedueUiResponse= new SchedueUiResponse();
			schedueUiResponse.setStartTime(schedule.getStartTime());
			schedueUiResponse.setEndTime(schedule.getEndTime());
			listOfScheduleUiResponse.add(schedueUiResponse);
		}
		return  listOfScheduleUiResponse;
	}

	public static Boolean checkConflict(AppointmentEntity appointment) {
		// TODO Auto-generated method stub
		String key = appointment.getDoctorId()+""+appointment.getSchedule().getDate();
		System.out.print(key);
		 Cache cache = cacheManager.getCache("doctorSchedule");
	        if (cache != null) {
	            Cache.ValueWrapper valueWrapper = cache.get(key);
	            		if (valueWrapper != null) {
	            	        ArrayList<ScheduleEntity> cachedData = (ArrayList<ScheduleEntity>) valueWrapper.get();
	            	        
	            	        for(ScheduleEntity e: cachedData)
	            	        {
	            	        	if(isTimeConflict(appointment,e))
	            	        	{
	            	        		return true;
	            	        	}
	            	        	//returns true if there is time conflict
	            	        }
	            			//System.out.print(cachedData);	            			
	               //eturn (YourObject) valueWrapper.get();
	            }
	        }
	        return false;
		
	}


	private static boolean isTimeConflict(AppointmentEntity appointment, ScheduleEntity e) {
		// TODO Auto-generated method stub
		  LocalTime start1 = appointment.getSchedule().getStartTime();
		    LocalTime end1 = appointment.getSchedule().getEndTime();
		    LocalTime start2 = e.getStartTime();
		    LocalTime end2 = e.getEndTime();

		    // Check for overlap or conflicts
		    boolean startsBeforeEnds = start1.isBefore(end2) || start1.equals(end2);
		    boolean endsAfterStarts = end1.isAfter(start2) || end1.equals(start2);
		    return startsBeforeEnds && endsAfterStarts;
		
	}

}
