package com.example.hospitalnearby1.doctors;

public class DoctorDTO {

	private Long doctorId;
	private String doctorName;
	private int experience;
	private int noOfOperationsTaken;
	private int operationsSuccess;
	private double successRatio;
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
	
	
}
