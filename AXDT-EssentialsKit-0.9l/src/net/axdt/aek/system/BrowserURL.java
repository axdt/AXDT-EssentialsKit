package net.axdt.aek.system;

import java.awt.Desktop;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;

public class BrowserURL {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static boolean browseURL(String url) {    
        if (OSName.Mac()) {       
        	try{
			    Class fileMgr = Class.forName("com.apple.eio.FileManager");    
                Method openURL = fileMgr.getDeclaredMethod("openURL", new Class[] { String.class });    
                openURL.invoke(null, new Object[] { url });  
                return true;  
            }catch (ClassNotFoundException e){
            	return false;
            }catch (NoSuchMethodException e){
            	return false;
            }catch (SecurityException e){
            	return false;
            }catch (IllegalAccessException e){
            	return false;
            }catch (IllegalArgumentException e){
            	return false;
            }catch (InvocationTargetException e){
            	return false;
            }catch (Exception e){
            	return false;
            }
        } else if (OSName.Windows()) {    
            try {
				Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
				return true;
			} catch (IOException e) {
				return false;
			}    
        } else {    
            // Unix or Linux    
            String[] browsers = { "firefox", "opera", "konqueror", "epiphany", "mozilla", "netscape" };    
            String browser = null;    
            for (int count = 0; count < browsers.length && browser == null; count++) {   
            	try{
                    if (Runtime.getRuntime().exec(new String[] { "which", browsers[count] }).waitFor() == 0)   
                        browser = browsers[count];  
            	}catch (IOException e){
            		return false;
            	} catch (InterruptedException e) {
            		return false;
				}
            }
            if (browser == null)    
                return false;   
            else {  
                try{  
                    Runtime.getRuntime().exec(new String[] { browser, url });   
                    return true;
                } catch(IOException e){
                	return false;
                }
            }
            
        }    
    }  
	
	public static boolean openURL(String URL){
		try {
			URI uri = new URI(URL);
			Desktop.getDesktop().browse(uri);
			return true;
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return false;
		} 
	}
	
}
