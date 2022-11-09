package App.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;


public class Debugger {
    private static Logger logger = LogManager.getLogger(Debugger.class.getName());

    public static void log(Object o) {
        System.out.println(o.toString());
    }


    public static void loggerPrintFatal(String message) {
        logger.fatal("Level: 100 - " + message);
    }

    public static void loggerPrintError(String message) {
        logger.error("Level: 200 - " + message);
    }

    public static void loggerPrintWarn(String message) {
        logger.warn("Level: 300 - " + message);
    }

    public static void loggerPrintInfo(String message) {
        logger.info("Level: 400 - " + message);
    }

    public static void loggerPrintDebug(String message) {
        logger.debug("Level: 500 - " + message);
    }

    public static void loggerPrintTrace(String message) {
        logger.trace("Level: 600 - " + message);
    }

    public static void stackTraces(IOException e) {
        System.out.println(e);
        Thread.dumpStack();
    }
}
