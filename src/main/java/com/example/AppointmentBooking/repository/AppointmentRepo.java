package com.example.AppointmentBooking.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.AppointmentBooking.entity.ScheduleEntity;

@Repository
public interface AppointmentRepo extends JpaRepository<AppointmentEntity, Integer>{
	
	@Query("SELECT se FROM ScheduleEntity se WHERE se.date = :date AND se.doctorId = :doctorId")
			
	List<ScheduleEntity> getDoctorSchedule(LocalDate date, int doctorId);
	
	

}
//    @Query("SELECT d FROM Doctor d WHERE d.speciality = :speciality")
