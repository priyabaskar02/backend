package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	           public int id;
    public String name;
    public String location;
    public String type;
    public double pricePerNight;
    public int capacity;
    public boolean available;
    public String roomNumber;

    public DemoApplication() {

	}

    public DemoApplication(int id, String name, String location, String type,
                double pricePerNight, int capacity,
                boolean available, String roomNumber) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.type = type;
        this.pricePerNight = pricePerNight;
        this.capacity = capacity;
        this.available = available;
        this.roomNumber = roomNumber;
    }
}
	
	


