module com.example.shoolmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.shoolmanager to javafx.fxml;
    exports com.example.shoolmanager;

    opens com.example.shoolmanager.Controllers to javafx.fxml;
    exports com.example.shoolmanager.Controllers;
}