package org.example.view;

import org.example.controller.ReservationController;
import org.example.controller.RoomController;
import org.example.entity.Reservation;
import org.example.entity.Room;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class RoomView {
    private RoomController roomController = new RoomController();

    public void showRooms() throws SQLException {
        List<Room> rooms = roomController.getAllRooms();
        System.out.println("Список комнат: ");
        rooms.forEach(room -> System.out.println(room.toString()));
    }

    public void createRoom() {
        try {
            Room newRoom = new Room();

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите номер комнаты: ");
            Integer number = scanner.nextInt();
            newRoom.setNumber(number);

            System.out.println("Введите кол-во мест в комнате: ");
            Integer amount = scanner.nextInt();
            newRoom.setNumber(amount);
            roomController.saveRoom(newRoom);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void deleteRoom() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id комнаты, которую хотите удалить: ");
        Long id = Long.parseLong(scanner.next());
        roomController.deleteRoom(id);
    }
    public void updateRoom() throws SQLException {
        try {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Введите id комнаты, которую хотите обновить: ");
            Long id = Long.parseLong(scanner1.next());

            Room newRoom;
            newRoom = roomController.getRoomById(id);

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введите номер комнаты: ");
            Integer number = scanner.nextInt();
            newRoom.setNumber(number);

            System.out.println("Введите кол-во мест в комнате: ");
            Integer amount = scanner.nextInt();
            newRoom.setNumber(amount);

            roomController.editRoom(newRoom);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getByIdRoom() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите id брони, которую хотите найти:");
        Long id = Long.parseLong(scanner.next());
        try {
            if (roomController.getRoomById(id) != null) {
                System.out.println(roomController.getRoomById(id).toString());
            } else {
                System.out.println("Такой комнаты не существует в базе");
            }

        } catch (NullPointerException | SQLException e) {
            System.out.println("Это не число ");
            System.out.println("Попробуйте еще раз, пожалуйста");
            getByIdRoom();
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
                    showRooms();
                    break;
                case 2:
                    createRoom();
                    break;
                case 3:
                    deleteRoom();
                    break;
                case 4:
                    updateRoom();
                    break;
                case 5:
                    getByIdRoom();
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
