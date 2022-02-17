module com.example.soccerapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.soccerapp to javafx.fxml;
    exports com.example.soccerapp;
}