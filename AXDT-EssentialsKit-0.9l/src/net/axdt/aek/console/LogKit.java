package net.axdt.aek.console;

import java.util.Date;
import java.text.SimpleDateFormat;

public class LogKit {

     public static void printInfo(String text){
    	 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//set format	 
    	 System.out.println("[ "+df.format(new Date())+" INFO] "+text);
     }
	 
	 public static void info(String text){
    	 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//set format	 
    	 System.out.println("[ "+df.format(new Date())+" INFO] "+text);
     }
	 
     public static void printWarning(String text){
    	 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//set format	 
    	 System.out.println("[ "+df.format(new Date())+" WARNING] "+text);
     }
	 
	 public static void warning(String text){
    	 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//set format	 
    	 System.out.println("[ "+df.format(new Date())+" WARNING] "+text);
     }
	 
     public static void printError(String text){
    	 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//set format	 
    	 System.out.println("[ "+df.format(new Date())+" ERROR] "+text);
     }
	 
	 public static void error(String text){
    	 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//set format	 
    	 System.out.println("[ "+df.format(new Date())+" ERROR] "+text);
     }
}
