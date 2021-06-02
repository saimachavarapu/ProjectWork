package com.example.hospitalnearby1.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hospitalnearby1.appointments.AppointmentDTO;
import com.example.hospitalnearby1.appointments.Appointments;
import com.example.hospitalnearby1.exception.UserNotFoundException;

@RestController()
public class UserController {
	
	@Autowired
	UserService service;

	@PostMapping("/user/register")
	public ResponseEntity<String> insertUser(@RequestBody User user) {
		if(service.isExistInDB(user)) {
			return new ResponseEntity<String>("The "+user.getName()+" is already registered", HttpStatus.FOUND);
		}
		else {
			service.addUserDetailsInDB(user);
			return new ResponseEntity<String>("The "+user.getName()+" is registered", HttpStatus.OK);
		}
	}
	
	
	@PostMapping("/user/login")
	public ResponseEntity<String> userLoginValidation(@RequestBody User user) {
		if(service.isValidUser(user)!=null) {
			return  new ResponseEntity<>("Valid User", HttpStatus.FOUND);
		}
		else {
			return  new ResponseEntity<>("Please register to login", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/user/appointments/{id}")
	public List<AppointmentDTO> appointments(@PathVariable("id") Long id) throws UserNotFoundException {
		List<Appointments> apps=service.getAppointments(id);
		List<AppointmentDTO> appointments=null;
		if(apps!=null) {
			appointments=new ArrayList<AppointmentDTO>();
			for(Appointments appointment: apps) {
				AppointmentDTO app=new AppointmentDTO();
				app.setAppointmentDate(appointment.getAppointmentDate());
				app.setAppointmentTime(appointment.getAppointmentTime());
				app.setUserName(appointment.getUser().getName());
				app.setDoctorName(appointment.getDoctors().getDoctorName());
				app.setDepartment(appointment.getDoctors().getSpec().getSplName());
				appointments.add(app);
			}
		}
		return appointments;
	}
}


//{
//"name":"harsha", 
//"password":"harsha123", 
//"email":"gvsshhrao1998@gmail.com"
//}