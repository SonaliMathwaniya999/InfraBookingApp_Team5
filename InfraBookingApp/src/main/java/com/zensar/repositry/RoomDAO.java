package com.zensar.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.model.Room;

@Repository
public interface RoomDAO extends JpaRepository<Room, Integer> {

}
