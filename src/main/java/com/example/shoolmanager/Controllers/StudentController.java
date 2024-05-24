package com.example.shoolmanager.Controllers;

import com.example.shoolmanager.Models.Student;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class StudentController {
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private DatePicker dateOfBirth;
    @FXML
    private TextField placeOfBirth;
    @FXML
    private TextField state;
    @FXML
    private TextField classroomId;

    @FXML
    void onSubmitUser() throws ParseException, SQLException {
        String email = this.email.getText().trim();
        String password = this.password.getText().trim();
        String firstName = this.firstName.getText().trim();
        String lastName = this.lastName.getText().trim();
        LocalDate dateOfBirth = this.dateOfBirth.getValue();
        String placeOfBirth = this.placeOfBirth.getText().trim();
        int state = Integer.parseInt(this.state.getText().trim());
        int classroomId = Integer.parseInt(this.classroomId.getText().trim());

        Student student = new Student();

        student.setEmail(email);
        student.setPassword(password);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setClassroomId(classroomId);
        try{
            student.setDateOfBirth(dateOfBirth);
        }catch (Exception e){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alert");
            alert.setContentText("Date format not valid");
            alert.showAndWait();
            return;
        }
        student.setPlaceOfBirth(placeOfBirth);
        student.setState(state);

        student.create(student);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("INFO");
        alert.setContentText("User registered successfully");
        alert.showAndWait();
    }

}
