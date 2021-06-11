package org.example.controller;

import org.example.entity.Room;
import org.example.entity.Staff;
import org.example.repository.Repo;
import org.example.repository.impl.StaffRepoImpl;

import java.sql.SQLException;
import java.util.List;

public class StaffController {
    private Repo repo = new StaffRepoImpl();

    public Staff editStaff(Staff staff) throws SQLException {
        return (Staff) repo.update(staff);
    }

    public List<Staff> getAllStaffs() throws SQLException {
        return repo.getAll();
    }

    public void saveStaff(Staff staff) throws SQLException {
        repo.add(staff);
    }

    public void deleteStaff(Long id) throws SQLException {
        repo.remove(id);
    }

    public Staff getStaffById(Long id) throws SQLException {
        return (Staff) repo.getById(id);
    }
}
