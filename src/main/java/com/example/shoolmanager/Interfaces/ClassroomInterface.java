package com.example.shoolmanager.Interfaces;

import com.example.shoolmanager.Models.Classroom;
import com.example.shoolmanager.Models.Student;

import java.util.List;

public interface ClassroomInterface {

    void create(Classroom classroom);
    List<Classroom> read(int id);
    void update(Classroom classroom);
    void delete(int id);

}
