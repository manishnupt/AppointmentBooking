package com.example.AppointmentBooking.uiRequest;

import java.time.LocalDate;
import java.time.LocalTime;

public class ScheduleUiRequest {

	private LocalDate date;
	private LocalTime startTime;
	private LocalTime endTime;
	private int doctorId;
	
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTIme(LocalTime endTime) {
		this.endTime = endTime;
	}
}
