package com.tenjava.entries.jshh.t2.util;

import com.tenjava.entries.jshh.t2.TenJava;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {

    private static Logger log;
    private static boolean debug = false;
    
    static {
        Log.log = TenJava.get().getLogger();
    }
    
    public static void log(Level level, String... msgs) {
        for(String m : msgs) {
            log.log(level, m);
        }
    }
    
    public static void info(String... msgs) {
        log(Level.INFO, msgs);
    }
    
    public static void debug(String... msgs) {
        if (debug) {
            info("[DEBUG] " + msgs);
        }
    }
    
    public static void warning(String... msgs) {
        log(Level.WARNING, msgs);
    }
    
    public static void severe(String... msgs) {
        log(Level.SEVERE, msgs);
    }
    
    public static void log(String... msgs) {
        info(msgs);
    }
    
    public static void exception(Exception e) {
        if(debug) {
            e.printStackTrace();
        } else {
            Log.warning("Exception from " + e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }
    
    public static boolean isDebugging() {
        return debug;
    }
    
    public static void setDebugging(boolean debugging) {
        Log.debug = debugging;
    }
    
    private Log() {}
    
}
