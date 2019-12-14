package com.sda.sdaApp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int idTeam;
    private String name;

    @OneToMany(mappedBy = "team")
    private List<Person> studentList = new ArrayList<>();

    public Team() {
    }

    public Team(int idTeam, String name, List<Person> studentList) {
        this.idTeam = idTeam;
        this.name = name;
        this.studentList = studentList;
    }

    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Person> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "Team{" +
                "idTeam=" + idTeam +
                ", name='" + name + '\'' +
                '}';
    }
}
