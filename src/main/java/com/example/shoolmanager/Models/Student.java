package com.example.shoolmanager.Models;

import com.example.shoolmanager.DbConfig.IDBConfig;
import com.example.shoolmanager.Interfaces.StudentInterface;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Student extends User implements StudentInterface {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String placeOfBirth;
    private int state = 0;
    private Connection connection;
    private int classroomId;

// User user = new User();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }


    @Override
    public void create(Student student) throws SQLException {

        /*try{
            this.connection = IDBConfig.getConnection();
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Alert");
            alert.setContentText("Connection database failed");
        }*/

        this.connection = IDBConfig.getConnection();

        if (this.connection != null){

            String req1 = "INSERT INTO user (email, password) VALUES (?, ?);";
            String req2 = "INSERT INTO student (firstname, lastname, dateOfBirth, placeOfBirth, state, classroom_id) VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement1 = this.connection.prepareStatement(req1);
            PreparedStatement preparedStatement2 = this.connection.prepareStatement(req2);
            preparedStatement1.setString(1, getEmail());
            preparedStatement1.setString(2, getPassword());

            preparedStatement2.setString(1, getFirstName());
            preparedStatement2.setString(2, getLastName());
            preparedStatement2.setDate(3, Date.valueOf(getDateOfBirth()));
            preparedStatement2.setString(4, getPlaceOfBirth());
            preparedStatement2.setInt(5, getState());
            preparedStatement2.setInt(6, getClassroomId());

            preparedStatement1.executeUpdate();
            preparedStatement2.executeUpdate();

            preparedStatement1.close();
            preparedStatement2.close();
            this.connection.close();
            System.out.println("User registered successfully !");
        }

    }

    @Override
    public List<Student> read(int id) {
        return List.of();
    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void delete(int id) {

    }
}
