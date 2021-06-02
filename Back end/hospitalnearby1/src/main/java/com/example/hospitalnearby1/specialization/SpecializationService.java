package com.example.hospitalnearby1.specialization;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecializationService {

	@Autowired
	private SpecializationRepository specializationRepository;

	public Specialization addSpecilizationIntoDB(Specialization specialization) {
		
		Specialization save = specializationRepository.save(specialization);
		return save;
	}

	public List<Specialization> getAllSpecializations() {
		List<Specialization> spec=specializationRepository.findAll();
		return spec;
	}
	
	public Specialization getSpecializationByName(String spec) {
		Specialization splName = specializationRepository.getBySplName(spec);
		return splName;
	}
	
	
}
