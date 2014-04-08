package net.axdt.aek.system;

import net.axdt.aek.file.RWKit;
import net.axdt.aek.string.StringKit;

public class Hosts {
	public static final String WINDOWS_HOSTS="C:\\WINDOWS\\System32\\drivers\\etc\\hosts";
	public static final String LINUX_HOSTS="/etc/hosts";
	public static final String MAC_HOSTS="/etc/hot";
	public static String HOSTS=getHostsFile();
	public static String getHostsFile(){
		if(OSName.Windows()){
			return WINDOWS_HOSTS;
		}
		else if(OSName.Linux()){
			return WINDOWS_HOSTS;
		}
		else if(OSName.Mac()){
			return WINDOWS_HOSTS;
		}
		return "";
	}
	public static boolean exist(String ip,String domain){
		return StringKit.includeNoCase(RWKit.readNoComment(HOSTS, "#"), ip+" "+domain);
	}
	public static boolean existIp(String ip){
		return StringKit.includeNoCase(RWKit.readNoComment(HOSTS, "#"), ip);
	}
	public static boolean existDomain(String domain){
		return StringKit.includeNoCase(RWKit.readNoComment(HOSTS, "#"), domain);
	}
	public static boolean add(String ip,String domain){
		return RWKit.writeLine2(HOSTS, ip+" "+domain);
	}
	public static boolean remove(String ip,String domain){
		return RWKit.clearData(HOSTS, ip+" "+domain);
	}

}
