package com.example.AppointmentBooking.businessLogic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.AppointmentBooking.entity.ScheduleEntity;
import com.example.AppointmentBooking.repository.AppointmentEntity;
import com.example.AppointmentBooking.service.AppointmentService;
import com.example.AppointmentBooking.uiRequest.BookAppointmentUiRequest;
import com.example.AppointmentBooking.uiRequest.DoctorScheduleUiRequest;
import com.example.AppointmentBooking.uiResponse.SchedueUiResponse;
import com.example.AppointmentBooking.utility.AppointmentHelper;

@Component
public class AppointmentBl {
	
	@Autowired
	AppointmentService service;
	

	public String bookAppointment(BookAppointmentUiRequest req) {
		// TODO Auto-generated method stub
		
		AppointmentEntity appointment =AppointmentHelper.convertFromUiRequest(req);
		AppointmentHelper.checkConflict(appointment);
		
		
		return service.bookAppointment(appointment);
		
	}


	public List<SchedueUiResponse> getDoctorSchedule(DoctorScheduleUiRequest request) {
		// TODO Auto-generated method stub
		
		List<ScheduleEntity> doctorSchedule = service.getDoctorSchedule(request);
		List<SchedueUiResponse> response =AppointmentHelper.convertToScheduleUiResponse(doctorSchedule);
		return response;
	}

}
