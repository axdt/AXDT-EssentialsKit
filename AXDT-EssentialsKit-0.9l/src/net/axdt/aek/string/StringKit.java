package net.axdt.aek.string;

public class StringKit {
    public static boolean equal(String com1,String com2){
    	return com1.equalsIgnoreCase(com2);
    }
    public static boolean equalNoCase(String com1,String com2){
    	return com1.toLowerCase().equalsIgnoreCase(com2.toLowerCase());
    }
    public static boolean include(String com1,String com2){
    	return (com1.indexOf(com2)>-1)||(com2.indexOf(com1)>-1);
    }
    public static boolean includeNoCase(String com1,String com2){
    	return (com1.toLowerCase().indexOf(com2.toLowerCase())>-1)||(com2.toLowerCase().indexOf(com1.toLowerCase())>-1);
    }
    public static String[] splitLine(String data){
    	return data.split("\n");
    }
    public static String getMiddle(String data,String left,String right){
    	return data.replaceAll("\\s", "").split(left)[1].split(right)[0];
    }
}
