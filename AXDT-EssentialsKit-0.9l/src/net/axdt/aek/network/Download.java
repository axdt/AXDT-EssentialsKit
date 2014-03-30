package net.axdt.aek.network;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Download {
	public static boolean downloadFile(String remote,String local){
		try {
            //int byteSum = 0;
            int byteRead = 0;
            //int byteCount = 0;
            URL url = new URL(remote);
            URLConnection conn = url.openConnection();
            //byteCount = conn.getContentLength();
            InputStream inStream = conn.getInputStream();
            FileOutputStream fs = new FileOutputStream(local);
            byte[] buffer = new byte[1204];
            while (( byteRead = inStream.read(buffer)) != -1) {
                //byteSum += byteRead;
                fs.write(buffer, 0, byteRead);
            }
            fs.close();
           return new File(local).exists();
        } catch (FileNotFoundException e) {
        	return false;
        } catch (IOException e) {
            return false;
        }
	}

}
