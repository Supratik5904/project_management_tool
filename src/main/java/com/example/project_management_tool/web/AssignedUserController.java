package com.example.project_management_tool.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project_management_tool.domain.AssignedUsers;
import com.example.project_management_tool.repositories.AssignedUserRepository;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = " * ", allowedHeaders = " * ")
public class AssignedUserController {
	
	@Autowired
	AssignedUserRepository aUserRepository;
	
	@GetMapping("all")
	public ResponseEntity<?> getUsers(){
		return new ResponseEntity<>(aUserRepository.findAll(),HttpStatus.OK);
	}

}
