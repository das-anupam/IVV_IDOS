package com.sparky.helper.ro;

import java.io.OutputStreamWriter;
import java.io.Serializable;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;


@SuppressWarnings("unused")
public class LogAccess{

private static final Logger log =  Logger.getLogger(LogAccess.class);
private static boolean initializationFlag = false;
private static String fileName=null;

private static void intializeLogger(){
	/*Logger.getLogger("org.apache.commons.httpclient").setLevel(Level.ERROR);
	Logger.getLogger("httpclient").setLevel(Level.ERROR);*/
	Logger.getLogger("org.apache.http").setLevel(org.apache.log4j.Level.OFF);
    ConsoleAppender ca = new ConsoleAppender();
    ca.setThreshold(Level.DEBUG);
    ca.setWriter(new OutputStreamWriter(System.out));
    ca.setLayout(new PatternLayout("%d{YYYY-MM-DD HH:mm:ss} [%-5p] [%c{1}] - [%M] %m%n"));
    ca.activateOptions();
    log.addAppender(ca);

    System.out.println("appender filename in LogAccess class is: "+fileName);
       
    FileAppender appender = new FileAppender();
  
    appender.setAppend(true);
  
    appender.setFile(System.getProperty("user.dir") + "\\target\\"+fileName + ".log");
      
    appender.setThreshold(Level.INFO);

    PatternLayout layOut = new PatternLayout();
    layOut.setConversionPattern("%d{YYYY-MM-DD HH:mm:ss} [%-5p] [%c{1}] - [%M] %m%n");
    appender.setLayout(layOut);
    appender.activateOptions();
    log.addAppender(appender);
  
    
    
}


public static Logger getLogger(){
	Logger.getRootLogger().setAdditivity(false);
	log.setLevel(Level.ALL);
	
    if(initializationFlag == false){
    	System.out.println("HERE TO INITIALIZE LOGGER AGAIN");
    	
        intializeLogger();
        initializationFlag = true;
        return LogAccess.log;
    }
    else{
        return LogAccess.log;
    }
}

public static void setFileName(String fileName){
    LogAccess.fileName = fileName;
    System.out.println("Filename in LogAccess setFilename() is: "+LogAccess.fileName);
  
}

public static boolean isInitializationFlag() {
	return initializationFlag;
}

public static void setInitializationFlag(boolean initializationFlag) {
	LogAccess.initializationFlag = initializationFlag;
}

public static String getFileName() {
	return fileName;
}

public static class RoleSpecificRollingFileAppender extends RollingFileAppender {
    @Override
    public void  setFile(String fileName) {
        super.setFile(fileName);
    }
}
public static void setFileAppender()
{
	org.apache.logging.log4j.core.LoggerContext ctx =
		    (org.apache.logging.log4j.core.LoggerContext) org.apache.logging.log4j.LogManager.getContext(false);
		ctx.reconfigure();
	System.out.println("Have ENTERED setFileAppender method in LogAccess class to change the file name to :"+fileName);
	
	((RollingFileAppender) Logger.getRootLogger().getAppender("appender")).setFile(System.getProperty("user.dir") + "\\target\\"+fileName + ".log");
}

}
