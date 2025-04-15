package Utils;

import org.apache.logging.log4j.LogManager;

public class LogsUtils {

    public static String logsPath = "test-outputs/Logs/";

    public static void info(String msg) {
        LogManager.getLogger(Thread.currentThread().getStackTrace()[2].toString()).info(msg);
    }

    public static void error(String msg){
        LogManager.getLogger(Thread.currentThread().getStackTrace()[20].toString()).error(msg);
    }

    public static void trace(String msg)
    {
        LogManager.getLogger(Thread.currentThread().getStackTrace()[2].toString()).trace(msg);
    }



}
