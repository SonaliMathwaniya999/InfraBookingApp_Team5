package com.zensar.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.Jwtutil.filter.TokenStorage;
import com.zensar.jwt.jwtutil.JwtUtil;
import com.zensar.model.Employee;
import com.zensar.model.LoginResponse;
import com.zensar.model.LoginUser;
import com.zensar.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private AuthenticationManager manager;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private EmployeeService employeeService;

	@PostMapping(value = "/addEmployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(this.employeeService.addEmployee(employee), HttpStatus.CREATED);
	}

	@PostMapping("/user/authenticate")
	public LoginResponse login(@RequestBody LoginUser user) {
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				user.getEmail(), user.getPassword());

		try {
			Authentication authenticate = this.manager.authenticate(authenticationToken);
			String token = jwtUtil.generateToken( user.getEmail());
//String token = jwtUtil.generateToken(user.getEmail());
			TokenStorage.storeToken(token, token);
			LoginResponse userResponse = new LoginResponse();
			userResponse.setJwt(token);
			return userResponse;
		} catch (Exception e) {
			throw e;
		}
	}
}