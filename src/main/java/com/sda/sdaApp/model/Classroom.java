package com.sda.sdaApp.model;

import javax.persistence.*;

@Entity
public class Classroom {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int idClassroom;
    private String name;

    public Classroom() {
    }

    public Classroom(int idClassroom, String name) {
        this.idClassroom = idClassroom;
        this.name = name;
    }

    public int getIdClassroom() {
        return idClassroom;
    }

    public void setIdClassroom(int idClassroom) {
        this.idClassroom = idClassroom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "idClassroom=" + idClassroom +
                ", name='" + name + '\'' +
                '}';
    }
}
