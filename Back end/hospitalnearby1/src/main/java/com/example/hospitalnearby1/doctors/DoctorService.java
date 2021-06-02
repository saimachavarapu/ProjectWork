package com.example.hospitalnearby1.doctors;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospitalnearby1.specialization.Specialization;
import com.example.hospitalnearby1.specialization.SpecializationService;

@Service
public class DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private SpecializationService service;

	public Doctors insertDoctorsIntoDB(String spec, Doctors doctors) {
		Specialization specialization = service.getSpecializationByName(spec);
		doctors.setSpec(specialization);
		doctors.setSuccessRatio((float) doctors.getOperationsSuccess() / doctors.getNoOfOperationsTaken());
		Doctors save = doctorRepository.save(doctors);
		return save;
	}

	public List<Doctors> getDoctorsOfSpecialization(String spec) {
		Specialization specializationByName = service.getSpecializationByName(spec);
		return specializationByName.getDoctors();
	}

	public Doctors getDoctorUsingId(Long id) {
		Doctors doctor=null;
		doctor = doctorRepository.getById(id);
		return doctor;
	}

	public boolean deleteDoctors(Long id) {
		Doctors doctor=this.getDoctorUsingId(id);
		if(doctor==null) {
			return false;
		}
		else {
			doctorRepository.deleteById(id);
			return true;
		}
	}

	public Doctors updateDoctors(Long id, Doctors doctor) {
		Doctors doc=this.getDoctorUsingId(id);
		doc.setDoctorName(doctor.getDoctorName());
		doc.setExperience(doctor.getExperience());
		doc.setNoOfOperationsTaken(doctor.getNoOfOperationsTaken());
		doc.setOperationsSuccess(doctor.getOperationsSuccess());
		doc.setSuccessRatio((float) doctor.getOperationsSuccess() / doctor.getNoOfOperationsTaken());
		Doctors save = doctorRepository.save(doc);
		return save;
	}
	
	
	
}
