package net.axdt.common.io;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class AXLogKit {

     public static void AXLog(String text){
    	 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//set format	 
    	 System.out.println("[ "+df.format(new Date())+" INFO] "+text);
     }
	 
	 public static void AXWarn(String text){
    	 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//set format	 
    	 System.out.println("[ "+df.format(new Date())+" INFO] "+text);
     }
	 
     public static void AXError(String text){
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
