package utils;

import models.Mentors;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class MentorSQLSerice {

    // Method Used To Create The Hibernate's SessionFactory Object
    private static SessionFactory getSessionFactory() {
        // Creating Configuration Instance & Passing Hibernate Configuration File
        Configuration configObj = new Configuration();
        configObj.configure("hibernate.cfg.xml");
        configObj.addAnnotatedClass(Mentors.class);

        // Since Hibernate Version 4.x, Service Registry Is Being Used
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();

        // Creating Hibernate Session Factory Instance
        return configObj.buildSessionFactory(serviceRegistryObj);
    }

    public static void getAll() {
        Transaction tx = null;
        try (Session session = getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            List mentors = session.createQuery("FROM mentors").list();
            for (Object o : mentors) {
                Mentors mentor = (Mentors) o;
                System.out.println(mentor);
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public int add(String name) {
        Session session = getSessionFactory().openSession();
        Transaction tx = null;
        int id = 0;

        try {
            tx = session.beginTransaction();
            Mentors mentor = new Mentors();
            mentor.setName(name);
            id = (int) session.save(mentor);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return id;
    }

    public void update(int id, String name) {
        Transaction tx = null;
        try (Session session = getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Mentors mentor = session.get(Mentors.class, id);
            mentor.setName(name);
            session.update(mentor);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        Transaction tx = null;
        try (Session session = getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Mentors mentor = session.get(Mentors.class, id);
            session.delete(mentor);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}
