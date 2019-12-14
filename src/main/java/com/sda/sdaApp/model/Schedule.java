package com.sda.sdaApp.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSchedule;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "idTrainer")
    private Person trainer;
    @ManyToOne
    @JoinColumn(name = "idClassroom")
    private Classroom classroom;
    @ManyToOne
    @JoinColumn (name = "idSubject")
    private Subject subject;
    @ManyToOne
    @JoinColumn(name = "idTeam")
    private Team team;

    @OneToMany(mappedBy = "student")
    private List<Attendance> attendanceList = new ArrayList<>();

    public Schedule() {
    }

    public Schedule(int idSchedule, Date date, Person trainerPerson, Classroom classroom, Subject subject, Team team) {
        this.idSchedule = idSchedule;
        this.date = date;
        this.trainer = trainerPerson;
        this.classroom = classroom;
        this.subject = subject;
        this.team = team;
    }

    public int getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(int idSchedule) {
        this.idSchedule = idSchedule;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Person getTrainer() {
        return trainer;
    }

    public void setTrainer(Person trainer) {
        this.trainer = trainer;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "idSchedule=" + idSchedule +
                ", date=" + date +
                ", trainerPerson=" + trainer +
                ", classroom=" + classroom +
                ", subject=" + subject +
                ", team=" + team +
                '}';
    }
}
