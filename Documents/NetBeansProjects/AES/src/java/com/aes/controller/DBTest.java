/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.controller;

import com.aes.model.User;
import com.aes.util.DAO;
import com.aes.util.HibernateUtility;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Siegfred
 */
public class DBTest {
    public static void main(String[] args) {
        User user = DAO.getUser("Chuck", "pass123");
        System.out.println(user.getRole());
        System.out.println(DAO.getUserByID(user.getId()).getName());
    }
}
