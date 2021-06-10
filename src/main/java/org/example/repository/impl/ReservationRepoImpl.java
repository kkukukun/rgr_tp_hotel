package org.example.repository.impl;

import org.example.entity.Reservation;
import org.example.repository.Repo;
import org.example.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class ReservationRepoImpl implements Repo<Reservation, Long> {
    private Session session;
    private Transaction transaction;
    @Override
    public void add(Reservation reservation) throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(reservation);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Reservation> getAll() throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        List<Reservation> reservations = session.createQuery("FROM Reservation").list();
        transaction.commit();
        session.close();
        return reservations;
    }

    @Override
    public Reservation getById(Long id) throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Reservation reservation = session.get(Reservation.class,id);
        transaction.commit();
        session.close();
        return reservation;
    }

    @Override
    public Reservation update(Reservation reservation) throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.saveOrUpdate(reservation);
        transaction.commit();
        session.close();
        return reservation;
    }

    @Override
    public void remove(Long id) throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Reservation reservation = session.get(Reservation.class,id);
        session.remove(reservation);
        transaction.commit();
        session.close();
    }
}
