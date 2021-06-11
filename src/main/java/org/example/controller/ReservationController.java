package org.example.controller;

import org.example.entity.Reservation;
import org.example.repository.Repo;
import org.example.repository.impl.ReservationRepoImpl;

import java.sql.SQLException;
import java.util.List;

public class ReservationController {
    private Repo repo = new ReservationRepoImpl();

    public Reservation editReservation(Reservation reservation) throws SQLException {
        return (Reservation) repo.update(reservation);
    }

    public List<Reservation> getAllReservations() throws SQLException {
        return repo.getAll();
    }

    public void saveReservation(Reservation reservation) throws SQLException {
        repo.add(reservation);
    }

    public void deleteReservation(Long id) throws SQLException {
        repo.remove(id);
    }
}
