package com.sda.sdaApp.dao;

import com.sda.sdaApp.model.Team;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sda.sdaApp.model.Person;
import com.sda.sdaApp.util.HibernateUtil;
import org.hibernate.query.Query;

import java.util.List;

public class PersonDao {

    public Person getPersonById(int idPerson) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Person p = session.get(Person.class, idPerson);

        session.close();

        return p;
    }

    public static List<Person> getAllStudents(){
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("from Person where isTrainer is false");

        List<Person> students = query.list();
        session.close();

        return students;
    }

    public static Person save(Person person) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        session.saveOrUpdate(person);

        transaction.commit();

        session.close();

        return person;
    }

    public void delete(Person person) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        session.delete(person);

        transaction.commit();

        session.close();
    }

    public static void deleteAllStudents(){
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("delete from Person where isTrainer is false");

        query.executeUpdate();
        transaction.commit();

        session.close();
    }
}