package org.example.exo14.service;

import org.example.exo14.model.Room;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class RoomService {
    private final Map<Long, Room> rooms = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public RoomService() {
        rooms.put(1L, new Room(1L, "Salle A", 10));
        rooms.put(2L, new Room(2L, "Salle B", 20));
        rooms.put(3L, new Room(3L, "Salle C", 15));
    }

    public List<Room> getAllRooms() {
        return new ArrayList<>(rooms.values());
    }

    public Room addRoom(Room room) {
        Long id = idCounter.getAndIncrement();
        room.setId(id);
        rooms.put(id, room);
        return room;
    }

    public void deleteRoom(Long id) {
        rooms.remove(id);
    }

    public boolean roomExists(Long id) {
        return rooms.containsKey(id);
    }
}

