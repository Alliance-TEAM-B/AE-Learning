/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.util;

import com.aes.model.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Siegfred
 */
public final class DAO {

    public static User getUser(String username, String password) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        User user = null;

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Object result = session.createQuery("FROM User WHERE username = :username AND password = :password")
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .uniqueResult();

            if (result != null) {
                user = (User) result;
                user.getCoursetakens().size();
                user.getExamtakens().size();
                Loggers.getLogger().log(Level.INFO, "User fetched: {0}", user.getName());
            }

            transaction.commit();
            
        } catch (Exception exception) {
            Loggers.getLogger().log(Level.SEVERE, "Exception: {0}", exception.getMessage());
            //LOGGER.log(Level.SEVERE, "Exception at getUser(username,password): " + exception.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }

        return user;
    }

    public static User getUserByID(int id) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        User user = null;

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Object result = session.get(User.class, id);/*createQuery("FROM User WHERE id = :id")
                    .setParameter("id", id)
                    .uniqueResult();*/

            if (result != null) {
                user = (User) result;
                user.getCoursetakens().size(); //mitigation against JSON failure due to hibernate Lazy Loading
                user.getExamtakens().size();
                Loggers.getLogger().log(Level.INFO, "User fetched: {0}", user.getName());
            } else {
                Loggers.getLogger().log(Level.WARNING, "user with id = {0} does not exist, this may indicate unregulated database access", id);
            }
            
            transaction.commit();
            
        } catch (Exception exception) {
            Loggers.getLogger().log(Level.SEVERE, "Exception: {0}", exception.getMessage());
            //LOGGER.log(Level.SEVERE, "Exception at getUser(username,password): " + exception.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }

        return user;
    }

    public static User addUser(String role, String name, String username, String password, String bunit, String type) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        User user = new User(role, name, username, password, bunit, type);

        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            Integer id = (Integer) session.save(user);

            user.setId(id);

            transaction.commit();
            Loggers.getLogger().log(Level.INFO, "User added: {0}", user.getName());
        } catch (Exception exception) {
            Loggers.getLogger().log(Level.SEVERE, "Exception: {0}", exception.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }

            user = null;
        } finally {
            session.close();
        }

        return user;
    }
    
    public static boolean deleteUser(int id) {
        Session session = HibernateUtility.getSessionFactory().openSession();
        //User user = new User(role, name, username, password, bunit, type);
        boolean erased = true;
        
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            Object user = session.get(User.class, id);
            
            if (user == null) {
                erased = false;
                Loggers.getLogger().log(Level.WARNING, "user with id = {0} does not exist, this may indicate unregulated database access", id);
            } else {
                session.delete(user);
                Loggers.getLogger().log(Level.INFO, "deleted user: {0}", id);
            }
            //user.setId(id);
            
            transaction.commit();
            
        } catch (Exception exception) {
            erased = false;
            //exception.printStackTrace();
            Loggers.getLogger().log(Level.SEVERE, "Exception: {0}", exception.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }

            //user = null;
        } finally {
            session.close();
        }

        return erased;
    }
}
