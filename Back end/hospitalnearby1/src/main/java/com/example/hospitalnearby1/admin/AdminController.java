package com.example.hospitalnearby1.admin;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

	@PostMapping("/admin/login")
	public ResponseEntity<String> adminLogin(@RequestBody Admin adminLogin) {
		if(adminLogin.getName().equals("admin") && adminLogin.getPassword().equals("admin")) {
			return new ResponseEntity<String>("Valid Credentials", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("In Valid Credentials for admin login", HttpStatus.NOT_FOUND);
		}
	}
}
