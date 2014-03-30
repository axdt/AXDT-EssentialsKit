package net.axdt.aek.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RWKit {
	public static final String LINE = "\n";
	public static final byte[] LINE_BYTES = LINE.getBytes();
	
    public static String read(String FileName){
    	 BufferedReader br = null;
         String data="";
         try {
             br = new BufferedReader(new FileReader(FileName));
             data = br.readLine();
             while( br.ready()){   
                   data += "\n"+br.readLine(); 
             }
               br.close();
               return data;
         } catch (Exception ex) {
             return "Exception";
         }
        
    }
    
    public static String readNoComment(String FileName,String CommentIcon){
   	 BufferedReader br = null;
        String data="";
        try {
            br = new BufferedReader(new FileReader(FileName));
            data = br.readLine();
            String temp;
            while( br.ready()){   
            	temp=br.readLine();
            	if(temp.startsWith(CommentIcon)||temp.startsWith(" "+CommentIcon))
            		temp="";
            	else
            		temp="\n"+temp;
                data += temp; 
            }
              br.close();
              return data;
        } catch (Exception ex) {
            return "Exception";
        }
       
   }
    
    public static boolean write(String FileName,String Data){
    	 FileWriter fw=null;
         try{
             fw = new FileWriter(FileName);
             fw.write(Data,0,Data.length()); 
             fw.flush();
             fw.close();
         }catch(Exception ex){
             //ex.printStackTrace();
        	 return false;
         }
         return true;
    }
    
    public static boolean clearData(String FileName,String Data){
    	return write(FileName,read(FileName).replaceAll(LINE+Data, "").replaceAll(Data+LINE, "").replaceAll(Data, ""));
   }
    
    public static boolean writeLine(String FileName,String Data){
    	File file = new File(FileName);
        //if there is, open it. if there isn't, create it.
        try{
            FileOutputStream fos = new FileOutputStream(file,true);
            fos.write(LINE_BYTES);
            fos.write(Data.getBytes());
            fos.close();
            return true;
        }
        catch(IOException e){
    	    return false;
        }
    }
    
    public static boolean writeLine2(String FileName,String Data){
    	return write(FileName,read(FileName)+LINE+Data);
    }
    
}
