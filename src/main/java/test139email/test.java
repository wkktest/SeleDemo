package test139email;

import java.io.File;

public class test {
    public static void main(String[]args){
          String ss = System.getProperty("user.dir");
          String s1 = ss + "\\drivers\\chromedirver.exe";
          System.out.println(s1);
       String s =  File.separator;
       System.out.println(s);
    }
}
