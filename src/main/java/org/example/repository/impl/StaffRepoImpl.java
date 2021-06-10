package org.example.repository.impl;
import org.example.entity.Staff;
import org.example.repository.Repo;
import org.example.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class StaffRepoImpl implements Repo<Staff,Long> {
    private Session session;
    private Transaction transaction;
    @Override
    public void add(Staff staff) throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(staff);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Staff> getAll() throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        List<Staff> staffs = session.createQuery("FROM Staff").list();
        transaction.commit();
        session.close();
        return staffs;
    }

    @Override
    public Staff getById(Long id) throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Staff staff = session.get(Staff.class,id);
        transaction.commit();
        session.close();
        return staff;
    }

    @Override
    public Staff update(Staff staff) throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.saveOrUpdate(staff);
        transaction.commit();
        session.close();
        return staff;
    }

    @Override
    public void remove(Long id) throws SQLException {
        session = Util.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Staff staff = session.get(Staff.class,id);
        session.remove(staff);
        transaction.commit();
        session.close();
    }
}
