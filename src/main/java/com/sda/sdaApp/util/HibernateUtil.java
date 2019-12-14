package com.sda.sdaApp.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.sda.sdaApp.model.Attendance;
import com.sda.sdaApp.model.Classroom;
import com.sda.sdaApp.model.Person;
import com.sda.sdaApp.model.Schedule;
import com.sda.sdaApp.model.Subject;
import com.sda.sdaApp.model.Team;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/sda_java?serverTimezone=UTC");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "root");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                settings.put(Environment.SHOW_SQL, "true");
                configuration.setProperties(settings);

                configuration.addAnnotatedClass(Attendance.class);
                configuration.addAnnotatedClass(Classroom.class);
                configuration.addAnnotatedClass(Person.class);
                configuration.addAnnotatedClass(Schedule.class);
                configuration.addAnnotatedClass(Subject.class);
                configuration.addAnnotatedClass(Team.class);

                sessionFactory = configuration.buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

}



