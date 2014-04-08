package net.axdt.aek.system;

import net.axdt.aek.string.StringKit;

public class OSName {
    public static String getOSName(){
    	return System.getProperty("os.name", "").toLowerCase();
    }
    public static boolean Mac(){
    	return StringKit.includeNoCase(getOSName(), "mac");
    }
    public static boolean Windows(){
    	return StringKit.includeNoCase(getOSName(), "win");
    }
    public static boolean Linux(){
    	return StringKit.includeNoCase(getOSName(), "lin");
    }
}
