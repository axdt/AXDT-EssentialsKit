package net.axdt.aek.system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import net.axdt.aek.string.StringKit;

public class Progress {
	
	public static String listTemp;
	
    public static String getProgressList(){
    	BufferedReader br = null;
    	Process proc = null;
    	String fia = "";
    	try {
    	    if(OSName.Windows())
        	    proc= Runtime.getRuntime().exec("tasklist");
        	else if(OSName.Linux())
    	        proc= Runtime.getRuntime().exec("top");
    	    br = new BufferedReader(new InputStreamReader(proc.getInputStream()));
    	    String line;
    	    while ((line = br.readLine()) != null) 
    	        fia+=line;
    	    br.close();
    	    listTemp = fia;
    	    return fia;
    	} catch (IOException e) {
    	    return "IOException";
    	}
    }
    
    public static String getProgressListLowerCase(){
    	return getProgressList().toLowerCase();
    }
    
    public static boolean progressing(String Name){
    	return StringKit.includeNoCase(getProgressListLowerCase(), Name);
    }
    
    public static boolean progressed(String Name){
    	return listTemp==null ? StringKit.includeNoCase(getProgressListLowerCase(), Name) : StringKit.includeNoCase(listTemp.toLowerCase(), Name);
    }
    public static boolean p360safe(){
    	return progressing("360safe");
    }
    public static boolean p360sd(){
    	return progressing("360sd");
    }
    public static boolean pbaiduan(){
    	return progressing("baiduan");
    }
    public static boolean pbaidusd(){
    	return progressing("baidusd");
    }
    public static boolean pqqmgr(){
    	String fia=getProgressListLowerCase();
    	return (fia.indexOf("qqpctray")>=0)||(fia.indexOf("qqpcrtp")>=0)||(fia.indexOf("qqpcmgr")>=0);
    }
    public static boolean pksafe(){
    	return progressing("ksafetray");
    }
    public static boolean pksd(){
    	return progressing("kasmain");
    }
    
    public static boolean pUnknownSafe(){
    	String fia=getProgressListLowerCase();
    	return (fia.indexOf("safe")>=0)||(fia.indexOf("sd")>=0)||(fia.indexOf("tray")>=0);
    }
    
}
