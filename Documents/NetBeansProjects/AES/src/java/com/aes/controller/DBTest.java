/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.controller;

import com.aes.model.User;
import com.aes.util.DAO;
import com.aes.util.HibernateUtility;
import com.aes.util.Loggers;
import java.util.List;
import java.util.logging.Level;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Siegfred
 */
public class DBTest {
    public static void main(String[] args) {
        System.out.println(DAO.deleteUser(5));
        Loggers.getLogger().log(Level.INFO, "Logger works");
        
        HibernateUtility.getSessionFactory().close();
    }
}
