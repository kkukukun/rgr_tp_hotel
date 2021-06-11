package org.example.controller;

import org.example.entity.Client;
import org.example.entity.Room;
import org.example.repository.Repo;
import org.example.repository.impl.RoomRepoImpl;

import java.sql.SQLException;
import java.util.List;

public class RoomController {
    private Repo repo = new RoomRepoImpl();

    public Room editRoom(Room room) throws SQLException {
        return (Room) repo.update(room);
    }

    public List<Room> getAllRooms() throws SQLException {
        return repo.getAll();
    }

    public void saveRoom(Room room) throws SQLException {
        repo.add(room);
    }

    public void deleteRoom(Long id) throws SQLException {
        repo.remove(id);
    }
    public Room getRoomById(Long id) throws SQLException {
        return (Room) repo.getById(id);
    }
}
