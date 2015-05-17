/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aes.util;

import java.io.File;
import java.io.IOException;
import java.util.TreeMap;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author Siegfred
 */
public class Loggers {
    
    private final Logger logger = Logger.getLogger("com.aes");
    
    private Loggers() {
        try {
            String logFile = System.getenv("USERPROFILE")+"\\My Documents\\AES.log";
            new File(logFile).createNewFile();
            logger.setUseParentHandlers(false);
            FileHandler handler = new FileHandler(logFile, true);
            handler.setFormatter(new SimpleFormatter());
            logger.addHandler(handler);
            
        } catch (IOException ex) {
            Logger.getLogger(Loggers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(Loggers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static Loggers getInstance() {
        return LoggersHolder.INSTANCE;
    }
    
    private static class LoggersHolder {
        private static final Loggers INSTANCE = new Loggers();
    }
    
    public static Logger getLogger() {
        return getInstance().logger;
    }
}
