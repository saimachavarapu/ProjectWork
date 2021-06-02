package com.example.hospitalnearby1.specialization;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class SpecializationController {

	@Autowired
	private SpecializationService service;
	
	@PostMapping("/specialization/add")
	public SpecializationDTO addSpecialization(@RequestBody Specialization specialization) {
		Specialization spec= service.addSpecilizationIntoDB(specialization);
		SpecializationDTO sp=new SpecializationDTO();
		sp.setSplId(spec.getSplId());
		sp.setSplName(spec.getSplName());
		return sp;
	}
	
	@GetMapping("/specialization/show")
	public List<SpecializationDTO> getSpecializations() {
		List<Specialization> allSpecializations = service.getAllSpecializations();
		List<SpecializationDTO> specailzation=new ArrayList<>();
		for(Specialization spec:allSpecializations) {
			SpecializationDTO sp=new SpecializationDTO();
			sp.setSplId(spec.getSplId());
			sp.setSplName(spec.getSplName());
			specailzation.add(sp);
		}
		return specailzation;
	}
}
