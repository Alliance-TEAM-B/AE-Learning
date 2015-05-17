/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.controller;

import com.aes.model.User;
import com.aes.util.DAO;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/usermanagement")
public class UserManagementController {
    //new User(role, name, username, password, bunit);
    @RequestMapping(value="register/{adminUsername}/{adminPassword}/{name}/{username}/{password}/{role}/{bunit}/{type}", method = RequestMethod.GET, headers= "Accept=application/json")
    public User registerUser(@PathVariable String adminUsername, @PathVariable String adminPassword, @PathVariable String name,
                             @PathVariable String username, @PathVariable String password, @PathVariable String role,
                             @PathVariable String bunit, @PathVariable String type) {
        
        User user = null;
        
        if (isAdmin(adminUsername, adminPassword)) {
            user = DAO.addUser(role, name, username, password, bunit, type);
        }
        
        return user;
    }
    
    
    @RequestMapping(value="delete/{adminUsername}/{adminPassword}/{userid}", method = RequestMethod.GET, headers= "Accept=application/json")
    public boolean deleteUser(@PathVariable String adminUsername, @PathVariable String adminPassword, @PathVariable int userid) {
        boolean erased = false;
        
        if (isAdmin(adminUsername, adminPassword)) {
             erased = DAO.deleteUser(userid);
        }
        
        return erased;
    }
    
            
    private boolean isAdmin(String username, String password) {
        return DAO.getUser(username, password).getType().equalsIgnoreCase("Admin");
    }
}
