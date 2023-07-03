package com.example.AppointmentBooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AppointmentBooking.businessLogic.AppointmentBl;
import com.example.AppointmentBooking.uiRequest.BookAppointmentUiRequest;
import com.example.AppointmentBooking.uiRequest.DoctorScheduleUiRequest;
import com.example.AppointmentBooking.uiResponse.SchedueUiResponse;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentBookingController {
	
	@Autowired
	AppointmentBl bl;
	
	@PostMapping("/bookAppointment")
	public String bookAppointment(@RequestBody BookAppointmentUiRequest req)
	{
		return bl.bookAppointment(req);
	}
	
	@PostMapping("/getListOfAppointments")
	public List<SchedueUiResponse> getDoctorSchedule(@RequestBody DoctorScheduleUiRequest request)
	{
		return bl.getDoctorSchedule(request);
	}

}
