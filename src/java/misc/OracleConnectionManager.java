 package misc;
 
 import java.sql.Connection;
 import java.sql.DriverManager;
 
 public class OracleConnectionManager
 {
   public static final int PROD = 0;
   public static final int STG = 1;
   public static final int DEV = 2;
   public static final int INT_DEV = 3;
   
   public static Connection getConnection(int environment)
   {
     try
     {
       Class.forName("oracle.jdbc.driver.OracleDriver");
       String url;
       Connection con;
       switch (environment) {
       case 0: 
         url = "jdbc:oracle:thin:@//trnesvp-scan.trans.ge.com:1621/tsesrvp";
         return DriverManager.getConnection(url, "SSO502159772", "WelC_012me");
       
       case 1: 
         url = "jdbc:oracle:thin:@//trnesvs-scan.trans.ge.com:1621/tsesrvs";
         return DriverManager.getConnection(url, "SSO502159772", "WelC_012me");
       
       case 2: 
         url = "jdbc:oracle:thin:@//trnesvd-scan.trans.ge.com:1621/tsesrvd";
         return DriverManager.getConnection(url, "SSO502159772", "WelC_012me");
       
       case 3: 
         url = "jdbc:oracle:thin:@//trnesvd-scan.trans.ge.com:1621/TSESRVI";
         return DriverManager.getConnection(url, "SSO502159772", "WelC_012me");
       }
       
       return null;
     }
     catch (Exception e)
     {     
     }
     
     return null;
   }
   
   
 }

//GE Confidential