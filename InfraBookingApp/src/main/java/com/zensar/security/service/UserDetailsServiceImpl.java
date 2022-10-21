package com.zensar.security.service;

import org.springframework.beans.factory.annotation.Autowired;
 

import org.springframework.security.core.userdetails.User;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.zensar.model.Employee;
import com.zensar.repositry.EmployeeDao;

public class UserDetailsServiceImpl implements UserDetailsService
{
	
	@Autowired
	private EmployeeDao dao;



	@Override
	public UserDetails loadUserByUsername(String email)throws UsernameNotFoundException
	{
	Employee foundUser=dao.findByEmail(email);
	System.out.println(foundUser);
	if(foundUser==null)
	{
	throw new UsernameNotFoundException(email);
	}
	User authenticatedUser=new User(foundUser.getEmail(),foundUser.getPassword(), foundUser.getRoles());

	return authenticatedUser;
	}



}