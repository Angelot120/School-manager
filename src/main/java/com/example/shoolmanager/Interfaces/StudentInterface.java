package com.example.shoolmanager.Interfaces;

import com.example.shoolmanager.Models.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentInterface {

    void create(Student student) throws SQLException;
    List<Student> read(int id);
    void update(Student student);
    void delete(int id);
}
