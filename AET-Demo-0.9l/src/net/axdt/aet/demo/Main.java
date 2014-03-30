package net.axdt.aet.demo;

import net.axdt.aek.EssentialKit;
import net.axdt.aek.Version;
import net.axdt.aek.console.LogKit;
import net.axdt.aek.file.RWKit;
import net.axdt.aek.file.ZIPKit;
import net.axdt.aek.network.Download;
import net.axdt.aek.network.WebKit;
import net.axdt.aek.string.StringKit;
import net.axdt.aek.system.Hosts;
import net.axdt.aek.system.TimeKit;

public class Main {
	public static void main(String[] args) {
		//LogKit.info 控制台记录
		//LogKit.warning 控制台警告
		//LogKit.error 控制台错误
		
		
		//控制台输出库版权
		EssentialKit.copyright();
		
		//控制台输出时间
		LogKit.info("Time Now:");
        LogKit.info(TimeKit.getTime());
        
        //控制台输出月份（英语）
        LogKit.info("Mouth:");
        LogKit.info(TimeKit.getMonth());
        
        //下载文件,并在控制台输出是否成功
        //Download.downloadFile(要下载的远程文件名,本地保存路径)
        LogKit.warning("Download Success?"+Download.downloadFile("http://dlsw.baidu.com/sw-search-sp/client2/common/install/4623968510/BaiduAn_50011.exe", "C:\\j\\1.exe"));
        
        //增加HOSTS条目
        LogKit.error("Add HOSTS Success?"+Hosts.add("127.0.0.1", "www.asanuiashuashd.com"));
        
        //删除HOSTS条目
        LogKit.error("Remove HOSTS Success?"+Hosts.remove("127.0.0.1", "www.asanuiashuashd.com"));
        
        //输出HOSTS文件位置
        LogKit.info(Hosts.HOSTS);
        
        //判断有无HOSTS解析到127.0.0.1
        LogKit.error("Is 127.0.0.1 HOSTS?"+Hosts.existIp("127.0.0.1"));
        
        //读取HOSTS文件，不读取注释
        LogKit.info(RWKit.readNoComment(Hosts.HOSTS,"#"));
        
        //判断HOSTS文件中有无127.0.0.1文本
        LogKit.error("Is 127.0.0.1 in HOSTS?"+StringKit.includeNoCase(RWKit.readNoComment(Hosts.HOSTS,"#"), "127.0.0.1"));
        
        //判断HOSTS中localhost是否解析到127.0.0.1
        LogKit.error("Is 127.0.0.1 localhost HOSTS?"+Hosts.exist("127.0.0.1","localhost"));
        
        //检查更新
        //EssentialKit.checkUpdate();
        //重写checkUpdate进行示范
        checkUpdate();
	}

	private static void checkUpdate() {
        //读取远程文本
        String Up=new WebKit().getHtml("http://bcs.duapp.com/openskin00/download/AEK.txt");
        //分割每一行
        String[] line=StringKit.splitLine(Up);
        //获取文本中间
        String ver=StringKit.getMiddle(line[2], "<VERSION>", "</VERSION>");
        //版本不一致
        if(!StringKit.includeNoCase(ver, Version.getVersion())){//有更新时
        	LogKit.error("Update Found");
        	LogKit.error("Now:"+Version.getVersion()+"New:"+ver);
        	String note="";
        	for(int i=3;i<line.length;i++)
        		note+=line[i];
        	LogKit.error("Update Note:"+StringKit.getMiddle(note, "<"+ver+">", "</"+ver+">").replace("<br>", "\n"));
        	//下载文件
        	Download.downloadFile("http://bcs.duapp.com/openskin00/download/AEK-full-"+ver+".zip", System.getProperty("java.class.path")+"/AEK-full-"+ver+".zip");
            try {
            	//解压ZIP
    			ZIPKit.decompress(System.getProperty("java.class.path")+"/AEK-full-"+ver+".zip",System.getProperty("java.class.path"));
    		} catch (Exception e) {
    		}
        }
	}

}
