package net.axdt.aek;

import net.axdt.aek.console.LogKit;
import net.axdt.aek.file.ZIPKit;
import net.axdt.aek.network.Download;
import net.axdt.aek.network.WebKit;
import net.axdt.aek.string.StringKit;

public class EssentialKit{

    public static void copyright(){
        LogKit.info("----AXDT----INFO----");
        LogKit.info("Project: "+Version.getProject());
        LogKit.info("Team: "+Version.getTeam());
        LogKit.info("Version: "+Version.getVersion());
        LogKit.info("--------------------");
    }
    public static void checkUpdate(){
        String Up=new WebKit().getHtml("http://bcs.duapp.com/openskin00/download/AEK.txt");
        String[] line=StringKit.splitLine(Up);
        String ver=StringKit.getMiddle(line[2], "<VERSION>", "</VERSION>");
        if(!StringKit.includeNoCase(ver, Version.getVersion())){
        	LogKit.error("Update Found");
        	LogKit.error("Now:"+Version.getVersion()+"New:"+ver);
        	String note="";
        	for(int i=3;i<line.length;i++)
        		note+=line[i];
        	LogKit.error("Update Note:"+StringKit.getMiddle(note, "<"+ver+">", "</"+ver+">").replace("<br>", "\n"));
        	Download.downloadFile("http://bcs.duapp.com/openskin00/download/AEK-full-"+ver+".zip", System.getProperty("java.class.path")+"/AEK-full-"+ver+".zip");
            try {
			    ZIPKit.decompress(System.getProperty("java.class.path")+"/AEK-full-"+ver+".zip",System.getProperty("java.class.path"));
		    } catch (Exception e) {
	     	}
        }
    }
	
}