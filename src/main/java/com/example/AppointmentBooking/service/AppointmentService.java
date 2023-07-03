package com.example.AppointmentBooking.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.AppointmentBooking.entity.ScheduleEntity;
import com.example.AppointmentBooking.repository.AppointmentEntity;
import com.example.AppointmentBooking.repository.AppointmentRepo;
import com.example.AppointmentBooking.uiRequest.DoctorScheduleUiRequest;


@Service
public class AppointmentService {
	
	@Autowired
	AppointmentRepo repo;

	public String bookAppointment(AppointmentEntity appointment) {
		// TODO Auto-generated method stub
		AppointmentEntity e= repo.save(appointment);
		if(e!=null)
		{
			return "Success";
		}
		return "Failure";
	}
    @Cacheable(value = "doctorSchedule", key = "#request")
	public List<ScheduleEntity> getDoctorSchedule(DoctorScheduleUiRequest request) {
		// TODO Auto-generated method stub
		List<ScheduleEntity> listOfSchedule =repo.getDoctorSchedule(request.getDate(),request.getDoctorId());
		return listOfSchedule;
		
	}

	
	

}
