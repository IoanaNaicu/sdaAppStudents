package com.sda.sdaApp.model;

import javax.persistence.*;

@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int idSubject;
    private String name;
    private String description;

    public Subject() {
    }

    public Subject(int idSubject, String name, String description) {
        this.idSubject = idSubject;
        this.name = name;
        this.description = description;
    }

    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "idSubject=" + idSubject +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
