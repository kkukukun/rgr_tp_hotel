package org.example.view;

import org.example.controller.ClientController;
import org.example.controller.StaffController;
import org.example.entity.Client;
import org.example.entity.Staff;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class StaffView {
    private StaffController staffController = new StaffController();

    public void showClients() throws SQLException {
        List<Staff> staffs = staffController.getAllStaffs();
        System.out.println("Список работников: ");
        staffs.forEach(staff -> System.out.println(staff.toString()));
    }

    public void createStaff() {
        try {
            Staff newStaff = new Staff();

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите имя: ");
            String name = scanner.nextLine();
            newStaff.setName(name);

            System.out.println("Введите фамилию: ");
            String lastname = scanner.nextLine();
            newStaff.setLastname(lastname);

            System.out.println("Введите должность: ");
            String sp = scanner.nextLine();
            newStaff.setSpeciality(sp);

            staffController.saveStaff(newStaff);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void deleteStaff() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id работника, которого хотите удалить: ");
        Long id = Long.parseLong(scanner.next());
        staffController.deleteStaff(id);
    }
    public void updateStaff() throws SQLException {
        try {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Введите id работника, которого хотите обновить: ");
            Long id = Long.parseLong(scanner1.next());

            Staff newStaff;
            newStaff = staffController.getStaffById(id);

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите имя: ");
            String name = scanner.nextLine();
            newStaff.setName(name);

            System.out.println("Введите фамилию: ");
            String lastname = scanner.nextLine();
            newStaff.setLastname(lastname);

            System.out.println("Введите должность: ");
            String sp = scanner.nextLine();
            newStaff.setSpeciality(sp);

            staffController.editStaff(newStaff);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getByIdStaff() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите id работника, которго хотите найти:");
        Long id = Long.parseLong(scanner.next());
        try {
            if (staffController.getStaffById(id) != null) {
                System.out.println(staffController.getStaffById(id).toString());
            } else {
                System.out.println("Такого работника не существует в базе");
            }

        } catch (NullPointerException | SQLException e) {
            System.out.println("Попробуйте еще раз, пожалуйста");
            getByIdStaff();
        }
    }
    public void run() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("\n Выберите опцию, пожалуйста :");
            System.out.println(" Введите число : ");
            System.out.println(" 1. Показать всех работников");
            System.out.println(" 2. Добавить нового работника");
            System.out.println(" 3. Удалить работника");
            System.out.println(" 4. Обновить информацию о работнике");
            System.out.println(" 5. Найти по id");
            System.out.println(" 6. Выйти ");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    showClients();
                    break;
                case 2:
                    createStaff();
                    break;
                case 3:
                    deleteStaff();
                    break;
                case 4:
                    updateStaff();
                    break;
                case 5:
                    getByIdStaff();
                    break;
                case 6:
                    run = false;
                    break;
                default:
                    System.out.println("Неверное число!");
            }
        }
    }
}
