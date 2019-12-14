package com.sda.sdaApp.dao;

import com.sda.sdaApp.model.Team;
import com.sda.sdaApp.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class TeamDao {
    public Team getTeamById(int idTeam){
        Session session = HibernateUtil.getSessionFactory().openSession();

        Team t = session.get(Team.class, idTeam);

        session.close();

        return t;
    }

    public static List<Team> getAllTeams(){
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("from Team");

        List<Team> teams = query.list();
        session.close();

        return teams;
    }

    public static List<Team> getAllTeamsOrderDescByName(){
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("from Team order by name desc");

        List<Team> teams = query.list();
        session.close();

        return teams;
    }

    public Team save(Team team) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        session.saveOrUpdate(team);

        transaction.commit();

        session.close();

        return team;
    }

    public void delete(Team teamn) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        session.delete(teamn);

        transaction.commit();

        session.close();
    }

    public static void deleteAllTeams(){
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("delete from Team");
        query.executeUpdate();

        transaction.commit();

        session.close();

    }

}
