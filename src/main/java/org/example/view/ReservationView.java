package org.example.view;

import org.example.controller.ReservationController;
import org.example.entity.Reservation;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ReservationView {
    private ReservationController reservationController = new ReservationController();

    public void showReservations() throws SQLException {
        List<Reservation> reservations = reservationController.getAllReservations();
        System.out.println("Список брони: ");
        reservations.forEach(reservation -> System.out.println(reservation.toString()));
    }

    public void createReservation() {
        try {
            Reservation newReservation = new Reservation();

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите цену: ");
            Float price = scanner.nextFloat();
            newReservation.setPrice(price);

            System.out.println("Введите дату: ");
            String date = scanner.nextLine();
            newReservation.setDate(date);
            reservationController.saveReservation(newReservation);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void deleteReservation() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id брони, которую хотите удалить: ");
        Long id = Long.parseLong(scanner.next());
        reservationController.deleteReservation(id);
    }
    public void updateReservation() throws SQLException {
        try {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Введите id брони, которую хотите обновить: ");
            Long id = Long.parseLong(scanner1.next());

            Reservation newReservation;
            newReservation = reservationController.getReservationById(id);

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите цену: ");
            Float price = scanner.nextFloat();
            newReservation.setPrice(price);

            System.out.println("Введите дату: ");
            String date = scanner.nextLine();
            newReservation.setDate(date);

            reservationController.editReservation(newReservation);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getByIdReservation() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите id брони, которую хотите найти:");
        Long id = Long.parseLong(scanner.next());
        try {
            if (reservationController.getReservationById(id) != null) {
                System.out.println(reservationController.getReservationById(id).toString());
            } else {
                System.out.println("Такой брони не существует в базе");
            }

        } catch (NullPointerException | SQLException e) {
            System.out.println("Это не число ");
            System.out.println("Попробуйте еще раз, пожалуйста");
            getByIdReservation();
        }
    }
    public void run() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("\n Выберите опцию, пожалуйста :");
            System.out.println(" Введите число : ");
            System.out.println(" 1. Показать все брони");
            System.out.println(" 2. Добавить новую бронь");
            System.out.println(" 3. Удалить бронрь");
            System.out.println(" 4. Обновить информацию о броне");
            System.out.println(" 5. Найти по id");
            System.out.println(" 6. Выйти ");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    showReservations();
                    break;
                case 2:
                    createReservation();
                    break;
                case 3:
                    deleteReservation();
                    break;
                case 4:
                    updateReservation();
                    break;
                case 5:
                    getByIdReservation();
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
