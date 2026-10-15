package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private List<Room> roomList = new ArrayList<>();
    private int currentId = 1;

    @PostMapping
    public ResponseEntity<?> createRoom(@RequestBody Room room) {
        
        // 1. Validation Checks (Returns 400 if invalid)
        if (room.getName() == null || room.getName().trim().length() < 3 || room.getName().trim().length() > 60 ||
            room.getLocation() == null || room.getLocation().trim().length() < 2 || room.getLocation().trim().length() > 40 ||
            room.getPricePerNight() == null || room.getPricePerNight() <= 0 || room.getPricePerNight() > 100000 ||
            room.getCapacity() == null || room.getCapacity() < 1 || room.getCapacity() > 10 ||
            room.getRoomNumber() == null || room.getRoomNumber().trim().length() < 4 || room.getRoomNumber().trim().length() > 20 ||
            room.getType() == null || !Arrays.asList("Single", "Double", "Suite", "Deluxe", "Family").contains(room.getType()) ||
            room.getAvailable() == null) {
            
            return ResponseEntity.status(400).body(Collections.singletonMap("error", "Invalid Data"));
        }

        // 2. Duplicate Room Number Check (Returns 409)
        for (Room r : roomList) {
            if (r.getRoomNumber().equalsIgnoreCase(room.getRoomNumber().trim())) {
                return ResponseEntity.status(409).body(Collections.singletonMap("error", "Duplicate Room Number"));
            }
        }

        // 3. Save and Return 201 Created
        room.setName(room.getName().trim());
        room.setLocation(room.getLocation().trim());
        room.setRoomNumber(room.getRoomNumber().trim());
        room.setId(currentId++);
        roomList.add(room);
        
        return ResponseEntity.status(201).body(room);
    }
}