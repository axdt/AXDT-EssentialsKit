package net.axdt.aek.properies;

import java.io.*;
import net.axdt.aek.exception.*;
public class AXP {
	public static final int READ = 0;
	public static final int WRITE = 1;
	public FileReader reader;
	public FileWriter writer;
	public File f;
	public byte[] linefeed = "\n".getBytes();
	public byte[] lk = "{".getBytes();
	public byte[] rk = "}".getBytes();
	int avil[] = null;
	public AXP(String filename,int openmode) throws AXInvaildArgumentException, AXInvaildAXPFileException{
    	if(openmode==0){
    		f = new File(filename);
    		try {
				reader = new FileReader(f);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
    		for(int i=0;i<=10;i++){
    			try {
					avil[i]=reader.read();
				} catch (IOException e) {
					e.printStackTrace();
				}
    		}
    		String check = avil.toString();
    		if(check.equals("<AXP Begin>")){
    			//do something
    		}
    		else{
    			throw new AXInvaildAXPFileException("Invaild AXP Header!");
    		}
    	}
    	else if(openmode==1){
    		f = new File(filename);
    		try {
				writer = new FileWriter(f);
				reader = new FileReader(f);
			} catch (IOException e) {
				e.printStackTrace();
			}
    		for(int i=0;i<=10;i++){
    			try {
					avil[i]=reader.read();
				} catch (IOException e) {
					e.printStackTrace();
				}
    		}
    		String check = avil.toString();
    		if(check.equals("<AXP Begin>")){
    			
    		}
    		else{
    			
    		}
    	}
    	else{
    		throw new AXInvaildArgumentException("Openmode is invaild");
    	}
    }
}
