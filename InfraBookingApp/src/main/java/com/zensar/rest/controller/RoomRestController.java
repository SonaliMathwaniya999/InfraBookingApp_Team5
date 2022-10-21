package com.zensar.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.model.Room;
import com.zensar.service.RoomService;

@RestController
public class RoomRestController {

	
	@Autowired
	private RoomService roomService;

	@PutMapping("/room/{id}")
	public Room updateMessage(@RequestBody  int code ) {
		
		return this.roomService.updateMessage(code);
		 
	}

	@PostMapping("/room")
	public Room createMessage(@RequestBody Room room) {
		return this.roomService.createMessage(room);
	}
	
	
	
	
}
