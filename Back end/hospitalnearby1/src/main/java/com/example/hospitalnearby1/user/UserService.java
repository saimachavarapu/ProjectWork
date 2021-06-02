package com.example.hospitalnearby1.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.example.hospitalnearby1.appointments.Appointments;
import com.example.hospitalnearby1.exception.UserNotFoundException;



@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public boolean isExistInDB(User user) {
		User byId = userRepository.getByName(user.getName());
		if(byId==null)
			return false;
		return true;
	}
	
	public void addUserDetailsInDB(User user) {
		userRepository.save(user);
	}
	
	public User isValidUser(User user) {
		User byId = userRepository.getByName(user.getName());
		if(isExistInDB(user)&&byId.equals(user)) {
			return user;
		}
		else {
			return null;
		}
	}
	
	public User getUser(Long id) throws UserNotFoundException {
		Optional<User> byId=userRepository.findById(id);
		if(!byId.isPresent()) {
			 throw new UserNotFoundException("The user with id - "+id+ " does not exists");
		}
		User user=userRepository.getById(id);
		return user;
	}

	public List<Appointments> getAppointments(Long id) throws UserNotFoundException {
		User user = this.getUser(id);
		List<Appointments> appointments=user.getAppointments();
		
		return appointments;
	}
		
}
