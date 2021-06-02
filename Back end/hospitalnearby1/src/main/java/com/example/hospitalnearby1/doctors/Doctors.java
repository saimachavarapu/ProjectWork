package com.example.hospitalnearby1.doctors;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.example.hospitalnearby1.appointments.Appointments;
import com.example.hospitalnearby1.specialization.Specialization;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Doctors {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long doctorId;
	private String doctorName;
	private int experience;
	private int noOfOperationsTaken;
	private int operationsSuccess;
	private double successRatio;
	
	@ManyToOne(targetEntity = Specialization.class)
	@JoinColumn(name = "spl_id", referencedColumnName = "splId")
	private Specialization spec;
	
	@OneToMany(targetEntity = Appointments.class, mappedBy = "doctors", fetch = FetchType.LAZY)
	private List<Appointments> appointments=new ArrayList<Appointments>();
	
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getNoOfOperationsTaken() {
		return noOfOperationsTaken;
	}
	public void setNoOfOperationsTaken(int noOfOperationsTaken) {
		this.noOfOperationsTaken = noOfOperationsTaken;
	}
	public int getOperationsSuccess() {
		return operationsSuccess;
	}
	public void setOperationsSuccess(int operationsSuccess) {
		this.operationsSuccess = operationsSuccess;
	}
	public double getSuccessRatio() {
		return successRatio;
	}
	public void setSuccessRatio(double successRatio) {
		this.successRatio = successRatio;
	}
	public Specialization getSpec() {
		return spec;
	}
	public void setSpec(Specialization spec) {
		this.spec = spec;
	}
	public List<Appointments> getAppointments() {
		return appointments;
	}
	public void setAppointments(List<Appointments> appointments) {
		this.appointments = appointments;
	}
//	@Override
//	public String toString() {
//		return "Doctors [doctorId=" + doctorId + ", doctorName=" + doctorName + ", experience=" + experience
//				+ ", noOfOperationsTaken=" + noOfOperationsTaken + ", operationsSuccess=" + operationsSuccess
//				+ ", successRatio=" + successRatio + ", spec=" + spec + ", appointments=" + appointments + "]";
//	}
//	
	
	
	
	
}
