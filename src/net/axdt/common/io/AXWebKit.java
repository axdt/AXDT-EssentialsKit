
package net.axdt.common.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AXWebKit{

/**
* 读取一个网页全部内容
*/
public String getOneHtml(final String htmlurl) throws IOException
{
URL url;
String temp;
final StringBuffer sb = new StringBuffer();
try
{
   url = new URL(htmlurl);
   final BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"));// 读取网页全部内容
   while ((temp = in.readLine()) != null)
   {
    sb.append(temp);
   }
   in.close();
}
catch (final MalformedURLException me)
{
   //System.out.println("你输入的URL格式有问题！请仔细输入");
   me.getMessage();
   throw me;
}
catch (final IOException e)
{
   e.printStackTrace();
   throw e;
}
return sb.toString();
}

/**
*
* @param s
* @return 获得网页标题
*/
public String getTitle(final String s)
{
String regex;
String title = "";
final List<String> list = new ArrayList<String>();
regex = "<title>.*?</title>";
final Pattern pa = Pattern.compile(regex, Pattern.CANON_EQ);
final Matcher ma = pa.matcher(s);
while (ma.find())
{
   list.add(ma.group());
}
for (int i = 0; i < list.size(); i++)
{
   title = title + list.get(i);
}
return outTag(title);
}

/**
*
* @param s
* @return 获得链接
*/
public List<String> getLink(final String s)
{
String regex;
final List<String> list = new ArrayList<String>();
regex = "<a[^>]*href=(\"([^\"]*)\"|\'([^\']*)\'|([^\\s>]*))[^>]*>(.*?)</a>";
final Pattern pa = Pattern.compile(regex, Pattern.DOTALL);
final Matcher ma = pa.matcher(s);
while (ma.find())
{
   list.add(ma.group());
}
return list;
}

/**
*
* @param s
* @return 获得脚本代码
*/
public List<String> getScript(final String s)
{
String regex;
final List<String> list = new ArrayList<String>();
regex = "<SCRIPT.*?</SCRIPT>";
final Pattern pa = Pattern.compile(regex, Pattern.DOTALL);
final Matcher ma = pa.matcher(s);
while (ma.find())
{
   list.add(ma.group());
}
return list;
}
public List<String> getNews(String s){
    String regex = "<a.*?</a>";
    Pattern pa = Pattern.compile(regex, Pattern.DOTALL);
    Matcher ma = pa.matcher(s);
    List<String> list = new ArrayList<String>();
    while (ma.find())
    {
       list.add(ma.group());

    }
    return list;
}
/**
*
* @param s
* @return 获得CSS
*/
public List<String> getCSS(final String s)
{
String regex;
final List<String> list = new ArrayList<String>();
regex = "<style.*?</style>";
final Pattern pa = Pattern.compile(regex, Pattern.DOTALL);
final Matcher ma = pa.matcher(s);
while (ma.find())
{
   list.add(ma.group());
}
return list;
}

/**
*
* @param s
* @return 去掉标记
*/
public String outTag(final String s)
{
return s.replaceAll("<.*?>", "");
}

}

