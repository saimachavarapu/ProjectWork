package com.example.hospitalnearby1.appointments;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hospitalnearby1.doctors.DoctorService;
import com.example.hospitalnearby1.doctors.Doctors;
import com.example.hospitalnearby1.exception.UserNotFoundException;
import com.example.hospitalnearby1.user.User;
import com.example.hospitalnearby1.user.UserService;

@Service
public class AppointmentService {

	@Autowired
	AppointmentRepository appointmentRepository;
	
	@Autowired
	UserService uService;
	
	@Autowired
	DoctorService dService;
	
	public Appointments bookAppointment(Long userId, Long doctorId, Appointments appointments) throws UserNotFoundException {
		if(this.checkIsDateValid(appointments.getAppointmentDate())) {
			List<Appointments> appointmentWithIn30Minutes = appointmentRepository.getAppointmentWithIn30Minutes(doctorId, appointments.getAppointmentDate(), appointments.getAppointmentTime());
			if(appointmentWithIn30Minutes.size()==0) {
				System.out.println(appointmentWithIn30Minutes);
				User user=uService.getUser(userId);
				Doctors doctor=dService.getDoctorUsingId(doctorId);
				appointments.setDoctors(doctor);
				appointments.setUser(user);
				Appointments save = appointmentRepository.save(appointments);
				return save;
			}
			else {
				System.out.println("No gap with that interval");
				return null;
			}
		}
		else {
			System.out.println("Date should be present or later 2 days");
			return null;
		}
		
	}

	private boolean checkIsDateValid(LocalDate appointmentDate) {

		LocalDate today=LocalDate.now();
		if(appointmentDate.isEqual(today) || appointmentDate.isAfter(today)) {
			Long days=ChronoUnit.DAYS.between(today, appointmentDate);
			System.out.println(days);
			if(days<=2) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
	
}
