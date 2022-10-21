package com.zensar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Room {

  @Id
  @GeneratedValue
  private int capacity;
  private String code;
   
  public Room() {
	super();
}
 
public Room(int capacity, String code) {
	super();
	this.capacity = capacity;
	this.code = code;
}

public int getCapacity() {
	return capacity;
}

public void setCapacity(int capacity) {
	this.capacity = capacity;
}

public String getCode() {
	return code;
}

public void setCode(String code) {
	this.code = code;
}




@Override
public String toString() {
	return "Room [capacity=" + capacity + ", code=" + code + "]";
}
	
   
  
  
	
}
