package com.sda.sdaApp;


import com.sda.sdaApp.dao.ClassroomDao;
import com.sda.sdaApp.dao.PersonDao;
import com.sda.sdaApp.dao.TeamDao;
import com.sda.sdaApp.model.Classroom;
import com.sda.sdaApp.model.Person;
import com.sda.sdaApp.model.Team;
import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;
import org.hibernate.PersistentObjectException;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static com.sda.sdaApp.dao.ClassroomDao.deleteAllClassroom;
import static com.sda.sdaApp.dao.ClassroomDao.getAllClassroom;
import static com.sda.sdaApp.dao.PersonDao.deleteAllStudents;
import static com.sda.sdaApp.dao.PersonDao.getAllStudents;
import static com.sda.sdaApp.dao.TeamDao.*;

public class App {
    public static void main(String[] args) {
        clearData();
        initializeData();
        //assignStudentsToList();
        //printList(getAllTeams());
        //printList(getAllStudents());
        //printList(getAllTeamsOrderDescByName());
        printList(getAllClassroom());

        clearData();
    }

    //initalizeaza datele
    private static void initializeData() {
        createTeams();
        createStudents();
        createClassrooms();

    }

    //sterge tabelele - aduce db la starea initiala
    private static void clearData() {
        deleteAllStudents();
        deleteAllTeams();
        deleteAllClassroom();

    }


    private static void createTeams() {
        TeamDao teamDao = new TeamDao();
        for (int i = 1; i <= 3; i++) {
            Team t = new Team();
            t.setName("Grupa" + i);

            teamDao.save(t);
        }
    }

    private static void createClassrooms(){
        ClassroomDao classroomDao = new ClassroomDao();
        for (int i = 1; i <= 3; i++){
            Classroom c = new Classroom();
            c.setName("Classroom" + i);

            classroomDao.save(c);
        }
    }

    private static void createStudents() {
        PersonDao personDao = new PersonDao();
        for (int i = 1; i <= 20; i++) {
            Person p = new Person();
            p.setFirstName("FirstName" + i);
            p.setLastName("LastName" + i);
            p.setEmail("name" + i + "@yahoo.com");
            p.setDateOfBirth(new Date());
            p.setTrainer(false);

            personDao.save(p);
        }
    }

    private static void assignStudentsToList(){
        List<Person> studentsList = PersonDao.getAllStudents();
        List<Team> teamList = TeamDao.getAllTeams();

        for(int i = 0; i<=3; i++){
            Person p = studentsList.get(i);
            p.setTeam(teamList.get(0));
            PersonDao.save(p);
        }
        for(int i = 4; i<=7; i++){
            Person p = studentsList.get(i);
            p.setTeam(teamList.get(1));
            PersonDao.save(p);
        }
        for(int i = 8; i<=19; i++){
            Person p = studentsList.get(i);
            p.setTeam(teamList.get(2));
            PersonDao.save(p);
        }
    }

    private static <T> void printList(List<T> list) {
        for (T t : list) {
            System.out.println(t);
        }
    }
}
