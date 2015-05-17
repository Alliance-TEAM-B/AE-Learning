/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.util;

import java.io.IOException;
import java.util.TreeMap;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Siegfred
 */
public class Loggers extends TreeMap<String, Logger>{
    
    private Loggers() {
    }
    
    private static Loggers getInstance() {
        return LoggersHolder.INSTANCE;
    }
    
    private static class LoggersHolder {
        private static final Loggers INSTANCE = new Loggers();
    }
    
    public void log(String className, Level level, String message) {
        if (!containsKey(className)) {
            try {
                Logger logger = Logger.getLogger(className);
                logger.setUseParentHandlers(false);
                
                logger.addHandler(new FileHandler(className, true));
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            } catch (SecurityException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
    }
}
