package com.example.hospitalnearby1.appointments;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.hospitalnearby1.doctors.Doctors;
import com.example.hospitalnearby1.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Appointments {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long appointmentId;
	private LocalDate appointmentDate;
	private LocalTime appointmentTime;
	@ManyToOne(targetEntity = Doctors.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_id", referencedColumnName = "doctorId")
	private Doctors doctors;
	@ManyToOne(targetEntity = User.class , fetch = FetchType.LAZY)
	@JoinColumn(name = "id", referencedColumnName = "id")
	private User user;
	
	public Long getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}
	public Doctors getDoctors() {
		return doctors;
	}
	public void setDoctors(Doctors doctors) {
		this.doctors = doctors;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public LocalTime getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(LocalTime appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	
	@Override
	public String toString() {
		return "Appointments [appointmentId=" + appointmentId + ", doctors=" + doctors + ", user=" + user
				+ ", appointmentDate=" + appointmentDate + ", appointmentTime=" + appointmentTime + "]";
	}
	
	
}
