package org.example.repository.impl;

import org.example.entity.Room;
import org.example.repository.Repo;
import org.example.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class RoomRepoImpl implements Repo<Room,Long> {
    private Session session;
    private Transaction transaction;
    @Override
    public void add(Room room) throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(room);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Room> getAll() throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        List<Room> rooms = session.createQuery("FROM Room").list();
        transaction.commit();
        session.close();
        return rooms;
    }

    @Override
    public Room getById(Long id) throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Room room = session.get(Room.class,id);
        transaction.commit();
        session.close();
        return room;
    }

    @Override
    public Room update(Room room) throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.saveOrUpdate(room);
        transaction.commit();
        session.close();
        return room;
    }

    @Override
    public void remove(Long id) throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Room room = session.get(Room.class,id);
        session.remove(room);
        transaction.commit();
        session.close();
    }
}
