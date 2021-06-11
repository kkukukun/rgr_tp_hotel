package org.example.view;

import java.sql.SQLException;
import java.util.Scanner;

public class View {

    private static View view;
    private ClientView clientView;
    private RoomView roomView;
    private ReservationView reservationView;
    private StaffView staffView;

    public View() {
        clientView = new ClientView();
        roomView = new RoomView();
        reservationView = new ReservationView();
        staffView = new StaffView();
    }

    public static View getInstance(){
        if(view==null){
            view = new View();
        }
        return view;
    }

    public void run() throws SQLException{
        Scanner scanner = new Scanner(System.in);
        boolean go = true;
        while (go) {
            System.out.println("\nВыберите опцию для операции: ");
            System.out.println("Введите число : ");
            System.out.println("1. Клиент");
            System.out.println("2. Бронь");
            System.out.println("3. Работники");
            System.out.println("4. Комната");
            System.out.println("5. Выход");

            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    runClient();
                    break;
                case 2:
                    runReservation();
                    break;
                case 3:
                    runStaff();
                    break;
                case 4:
                    runRoom();
                    break;
                case 5:
                    go = false;
                    break;
                default:
                    System.out.println("Не верное число");
                    System.out.println("Введите числа от 1 до 4, пожалуйста");
            }
        }
    }

    private void runClient() throws SQLException {
        clientView.run();
    }

    private void runReservation() throws SQLException {
        reservationView.run();
    }

    private void runStaff() throws SQLException {
        staffView.run();
    }

    private void runRoom() throws SQLException {
        roomView.run();
    }

}
