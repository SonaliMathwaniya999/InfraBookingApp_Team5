package com.zensar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
 
import com.zensar.model.Room;
 import com.zensar.repositry.RoomDAO;

@Service
public class RoomService {

	List<Room> rooms;
	@Autowired
	private RoomDAO dao;
	
	
	
	
	
	
	
	
	public RoomService() {
		super();
		
		
		this.rooms = new ArrayList<>();
		
		
	}
 
	
	public Room updateMessage(  int code ) {
		
Optional<Room> optional=this.dao.findById(code);
		
		if(optional.isPresent())
			return optional.get();
		else
			return null;
		 
	}

	 
	public Room createMessage(  Room room) {
		return this.dao.save(room);
	}
	
	 
	
}
