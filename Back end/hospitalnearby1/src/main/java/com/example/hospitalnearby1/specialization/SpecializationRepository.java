package com.example.hospitalnearby1.specialization;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecializationRepository extends JpaRepository<Specialization, Long> {
	
	Specialization getBySplName(String spec);
}
