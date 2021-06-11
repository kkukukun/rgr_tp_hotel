package org.example.view;

import java.sql.SQLException;

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

    }
}
