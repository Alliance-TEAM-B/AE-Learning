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
@RequestMapping(value = "/login")
public class LoginController {
    @RequestMapping(value = "/{username}/{password}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Object login(@PathVariable String username, @PathVariable String password) {
        return DAO.getUser(username, password);
    }
}
