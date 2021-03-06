package net.axdt.aek.file;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZIPKit {
	public static final String EXT = ".zip";  
    private static final int BUFFER = 1024;  
  
    /** 
     * Decompress ZIP File 
     *  
     * @param srcPath 
     * @throws Exception 
     */  
    public static void decompress(String srcPath) throws Exception {  
        File srcFile = new File(srcPath);  
  
        decompress(srcFile);  
    }  
  
    /** 
     * Decompress ZIP File 
     *  
     * @param srcFile 
     * @throws Exception 
     */  
    public static void decompress(File srcFile) throws Exception {  
        String basePath = srcFile.getParent();  
        decompress(srcFile, basePath);  
    }  
  
    /** 
     * Decompress ZIP File 
     *  
     * @param srcFile 
     * @param destFile 
     * @throws Exception 
     */  
    public static void decompress(File srcFile, File destFile) throws Exception {  
  
        CheckedInputStream cis = new CheckedInputStream(new FileInputStream(srcFile), new CRC32());  
  
        ZipInputStream zis = new ZipInputStream(cis);  
  
        decompress(destFile, zis);  
  
        zis.close();  
  
    }  
  
    /** 
     * Decompress ZIP File  
     *  
     * @param srcFile 
     * @param destPath 
     * @throws Exception 
     */  
    public static void decompress(File srcFile, String destPath)  
            throws Exception {  
        decompress(srcFile, new File(destPath));  
  
    }  
  
    /** 
     * Decompress ZIP File 
     *  
     * @param srcPath 
     * @param destPath 
     * @throws Exception 
     */  
    public static void decompress(String srcPath, String destPath)  
            throws Exception {  
  
        File srcFile = new File(srcPath);  
        decompress(srcFile, destPath);  
    }  
  
    /** 
     * Decompress ZIP File  
     *  
     * @param destFile 
     * @param zis 
     *            ZipInputStream 
     * @throws Exception 
     */  
    private static void decompress(File destFile, ZipInputStream zis)  
            throws Exception {  
  
        ZipEntry entry = null;  
        while ((entry = zis.getNextEntry()) != null) {  
  
            String dir = destFile.getPath() + File.separator + entry.getName();  
  
            File dirFile = new File(dir);  
            fileProber(dirFile);  
  
            if (entry.isDirectory()) {  
                dirFile.mkdirs();  
            } else {  
                decompressFile(dirFile, zis);  
            }  
  
            zis.closeEntry();  
        }  
    }  
  
    /** 
     * Find File
     *  
     *  When father directory is not found.
     *  Create directory
     *  
     * @param dirFile 
     */  
    private static void fileProber(File dirFile) {  
  
        File parentFile = dirFile.getParentFile();  
        if (!parentFile.exists()) {  
            fileProber(parentFile);  
            parentFile.mkdir();  
        }  
  
    }  
  
    /** 
     * Decompress ZIP File  
     *  
     * @param destFile  
     * @param zis 
     *            ZipInputStream 
     * @throws Exception 
     */  
    private static void decompressFile(File destFile, ZipInputStream zis)  
            throws Exception {  
  
        BufferedOutputStream bos = new BufferedOutputStream(  
                new FileOutputStream(destFile));  
  
        int count;  
        byte data[] = new byte[BUFFER];  
        while ((count = zis.read(data, 0, BUFFER)) != -1) {  
            bos.write(data, 0, count);  
        }  
  
        bos.close();  
    }  
}
