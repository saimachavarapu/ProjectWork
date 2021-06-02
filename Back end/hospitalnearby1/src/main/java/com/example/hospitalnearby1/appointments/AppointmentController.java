package com.example.hospitalnearby1.appointments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hospitalnearby1.exception.UserNotFoundException;

@RestController
public class AppointmentController {
	

	@Autowired
	AppointmentService service1;
	
	@PostMapping("/appointments/user/{userid}/doctor/{doctorid}")
	public AppointmentDTO saveAppointment(@PathVariable("userid") Long userid, @PathVariable("doctorid") Long doctorid, @RequestBody Appointments appointment) throws UserNotFoundException  {
	
		Appointments appointments=service1.bookAppointment(userid, doctorid, appointment);
		if(appointments!=null) {
			AppointmentDTO app=this.getAppointmentDTO(appointments);
			return app;
		}
		else {
			return null;
		}
	}

	private AppointmentDTO getAppointmentDTO(Appointments appointments) {

		AppointmentDTO app=new AppointmentDTO();
		app.setAppointmentDate(appointments.getAppointmentDate());
		app.setAppointmentTime(appointments.getAppointmentTime());
		app.setUserName(appointments.getUser().getName());
		app.setDoctorName(appointments.getDoctors().getDoctorName());
		app.setDepartment(appointments.getDoctors().getSpec().getSplName());
		return app;
	}
	
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		System.out.println("Inside Initbinder");
////		binder.registerCustomEditor(LocalDate.class, "appointmentDate",  new CustomDatePropertyEditor());
//	}
}



//{
//"appointmentDate":"2021-05-28",
//"appointmentTime":"10:50"
//}
