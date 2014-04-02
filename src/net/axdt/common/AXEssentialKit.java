package net.axdt.common;

import net.axdt.common.io.*;
import java.util.logging.*;
public class AXEssentialKit{

    public static void copyright(){
	    AXLogKit.AXLog("----AXDT----INFO----");
        AXLogKit.AXLog("Project: "+Version.getProject());
		AXLogKit.AXLog("Team: "+Version.getTeam());
		AXLogKit.AXLog("Version: "+Version.getVersion());
		AXLogKit.AXLog("--------------------");
    }
	
}