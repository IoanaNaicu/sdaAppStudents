package com.sda.sdaApp.model;

import javax.persistence.*;

@Entity
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAttendance;
    private boolean isPresent;
    private String comments;
    @ManyToOne
    @JoinColumn(name = "idSchedule", nullable = false)
    private Schedule schedule;
    @ManyToOne
    @JoinColumn(name = "idStudent", nullable = false)
    private Person student;

    public Attendance() {
    }

    public Attendance(int idAttendance, boolean isPresent, String comments, Schedule schedule, Person studentPerson) {
        this.idAttendance = idAttendance;
        this.isPresent = isPresent;
        this.comments = comments;
        this.schedule = schedule;
        this.student = studentPerson;
    }

    public int getIdAttendance() {
        return idAttendance;
    }

    public void setIdAttendance(int idAttendance) {
        this.idAttendance = idAttendance;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Person getStudent() {
        return student;
    }

    public void setStudent(Person student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "idAttendance=" + idAttendance +
                ", isPresent=" + isPresent +
                ", comments='" + comments + '\'' +
                ", schedule=" + schedule +
                ", studentPerson=" + student +
                '}';
    }
}
