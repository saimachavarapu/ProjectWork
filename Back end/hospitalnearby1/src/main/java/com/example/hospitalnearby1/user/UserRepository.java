package com.example.hospitalnearby1.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

	User getByName(String name);
	

}
