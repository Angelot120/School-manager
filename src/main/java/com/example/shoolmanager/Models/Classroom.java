package com.example.shoolmanager.Models;

import com.example.shoolmanager.Interfaces.ClassroomInterface;

import java.util.List;

public class Classroom implements ClassroomInterface {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void create(Classroom classroom) {

    }

    @Override
    public List<Classroom> read(int id) {
        return List.of();
    }

    @Override
    public void update(Classroom classroom) {

    }

    @Override
    public void delete(int id) {

    }
}
