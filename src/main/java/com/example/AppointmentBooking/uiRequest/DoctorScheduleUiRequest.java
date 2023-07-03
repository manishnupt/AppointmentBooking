package com.example.AppointmentBooking.uiRequest;

import java.time.LocalDate;

public class DoctorScheduleUiRequest {
	
	private LocalDate date;
	private int doctorId;
	public LocalDate getDate() {
		return date;
	}
	
	@Override
	public String toString() {
		return  doctorId +""+date  ;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

}
