package com.example.AppointmentBooking.uiRequest;

public class BookAppointmentUiRequest {
	
	private String patientId;
	private int doctorId;
	private String bookingId;
	private String additionalNotes;
	private ScheduleUiRequest schedule;
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public String getAdditionalNotes() {
		return additionalNotes;
	}
	public void setAdditionalNotes(String additionalNotes) {
		this.additionalNotes = additionalNotes;
	}
	public ScheduleUiRequest getScheduleReq() {
		return schedule;
	}
	public void setScheduleReq(ScheduleUiRequest scheduleReq) {
		this.schedule = scheduleReq;
	}
	

}
