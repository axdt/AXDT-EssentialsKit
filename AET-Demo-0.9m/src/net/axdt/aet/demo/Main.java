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
		//LogKit.info ����̨��¼
		//LogKit.warning ����̨����
		//LogKit.error ����̨����
		
		
		//����̨������Ȩ
		EssentialKit.copyright();
		
		//����̨���ʱ��
		LogKit.info("Time Now:");
        LogKit.info(TimeKit.getTime());
        
        //����̨����·ݣ�Ӣ�
        LogKit.info("Mouth:");
        LogKit.info(TimeKit.getMonth());
        
        //�����ļ�,���ڿ���̨����Ƿ�ɹ�
        //Download.downloadFile(Ҫ���ص�Զ���ļ���,���ر���·��)
        LogKit.warning("Download Success?"+Download.downloadFile("http://dlsw.baidu.com/sw-search-sp/client2/common/install/4623968510/BaiduAn_50011.exe", "C:\\j\\1.exe"));
        
        //����HOSTS��Ŀ
        LogKit.error("Add HOSTS Success?"+Hosts.add("127.0.0.1", "www.asanuiashuashd.com"));
        
        //ɾ��HOSTS��Ŀ
        LogKit.error("Remove HOSTS Success?"+Hosts.remove("127.0.0.1", "www.asanuiashuashd.com"));
        
        //���HOSTS�ļ�λ��
        LogKit.info(Hosts.HOSTS);
        
        //�ж�����HOSTS������127.0.0.1
        LogKit.error("Is 127.0.0.1 HOSTS?"+Hosts.existIp("127.0.0.1"));
        
        //��ȡHOSTS�ļ�������ȡע��
        LogKit.info(RWKit.readNoComment(Hosts.HOSTS,"#"));
        
        //�ж�HOSTS�ļ�������127.0.0.1�ı�
        LogKit.error("Is 127.0.0.1 in HOSTS?"+StringKit.includeNoCase(RWKit.readNoComment(Hosts.HOSTS,"#"), "127.0.0.1"));
        
        //�ж�HOSTS��localhost�Ƿ������127.0.0.1
        LogKit.error("Is 127.0.0.1 localhost HOSTS?"+Hosts.exist("127.0.0.1","localhost"));
        
        //������
        //EssentialKit.checkUpdate();
        //��дcheckUpdate����ʾ��
        checkUpdate();
	}

	private static void checkUpdate() {
        //��ȡԶ���ı�
        String Up=new WebKit().getHtml("https://raw.githubusercontent.com/axdt/AXDT-EssentialsKit/master/AEK.txt");
        //�ָ�ÿһ��
        String[] line=StringKit.splitLine(Up);
        //��ȡ�ı��м�
        String ver=StringKit.getMiddle(line[2], "<VERSION>", "</VERSION>");
        //�汾��һ��
        if(!StringKit.includeNoCase(ver, Version.getVersion())){//�и���ʱ
        	LogKit.error("Update Found");
        	LogKit.error("Now:"+Version.getVersion()+"New:"+ver);
        	String note="";
        	for(int i=3;i<line.length;i++)
        		note+=line[i];
        	LogKit.error("Update Note:"+StringKit.getMiddle(note, "<"+ver+">", "</"+ver+">").replace("<br>", "\n"));
        	//�����ļ�
        	Download.downloadFile("https://codeload.github.com/axdt/AXDT-EssentialsKit/zip/master", System.getProperty("user.dir")+"/AEK-full-"+ver+".zip");
            try {
            	//��ѹZIP
    			ZIPKit.decompress(System.getProperty("user.dir")+"/AEK-full-"+ver+".zip",System.getProperty("user.dir"));
    		} catch (Exception e) {
    		}
        }
	}

}
