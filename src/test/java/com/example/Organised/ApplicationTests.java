package com.example.Organised;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ApplicationTests {
	@Autowired
	RoomRepository repository;

	@Test
	void contextLoads() {
	}
	@Test
	void canWeAddARoom() {
		Room garage = new Room("Garage");
		String result = garage.getRoom();
		Assertions.assertEquals("Garage", result);
	}

}
