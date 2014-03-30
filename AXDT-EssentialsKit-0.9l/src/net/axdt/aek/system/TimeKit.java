package net.axdt.aek.system;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeKit {
    public static String getTime(){
    	 return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
    
    public static String getTime(String Format){
   	     return new SimpleDateFormat(Format).format(new Date());
    }
    
  
    @SuppressWarnings("deprecation")
	public static String getMonth(){
 	     switch(new Date().getMonth()){
 	     case 0:
 	    	 return "Jan";
 	     case 1:
	    	 return "Feb";
 	     case 2:
	    	 return "Mar";
 	     case 3:
	     	 return "Apr";
 	     case 4:
	    	 return "May";
 	     case 5:
    	     return "Jun";
 	     case 6:
    	     return "Jul";
 	     case 7:
    	     return "Aug";
 	     case 8:
    	     return "Sep";
 	     case 9:
    	     return "Oct";
 	     case 10:
    	     return "Nov";
 	     case 11:
    	     return "Dec";
    	 default:
    		 return "Unknown";
 	     }
    }
 
}
