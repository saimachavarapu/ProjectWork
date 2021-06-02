package com.example.hospitalnearby1.appointments;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AppointmentRepository extends JpaRepository<Appointments, Long>{
	
	@Query(value = "select * from Appointments where doctor_id= :id and appointment_date= :date and appointment_time between subtime( :time, \"00:30:00\") and addtime( :time, \"00:30:00\")", nativeQuery = true)
	List<Appointments> getAppointmentWithIn30Minutes(@Param("id") Long id, @Param("date") LocalDate date, @Param("time") LocalTime time);

}
