module com.example.simpleapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.simpleapp to javafx.fxml;
    exports com.example.simpleapp;
}