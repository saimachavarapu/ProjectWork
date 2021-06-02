package com.example.hospitalnearby1.specialization;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.hospitalnearby1.doctors.Doctors;
import com.sun.istack.NotNull;

@Entity
@Table(name = "hospital")
public class Specialization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long splId;
	@NotNull
	private String splName;
	@OneToMany(targetEntity = Doctors.class, mappedBy = "spec")
	private List<Doctors> doctors=new ArrayList<>();
	
	public Long getSplId() {
		return splId;
	}
	public void setSplId(Long splId) {
		this.splId = splId;
	}
	public String getSplName() {
		return splName;
	}
	public void setSplName(String splName) {
		this.splName = splName;
	}
	public List<Doctors> getDoctors() {
		return doctors;
	}
	public void setDoctors(List<Doctors> doctors) {
		this.doctors = doctors;
	}
//	@Override
//	public String toString() {
//		return "Specialization [splId=" + splId + ", splName=" + splName + ", doctors=" + doctors + "]";
//	}
	
	
}
