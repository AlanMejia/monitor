/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eServices.serviceClasses;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import misc.OracleConnectionManager;
import org.springframework.stereotype.Service;

/**
 *
 * @author 779609
 */
@Service
public class LanguageService implements Serializable{
    
    Connection con=OracleConnectionManager.getConnection(OracleConnectionManager.PROD); 
        
         private String result;
         String userName;
         String eserv1;
         String eserv2;
         String user;
       
         private int i;
         private String script;
        
       
        
          
           String myQuery = "Select (employee_firstname || ' ' || employee_lastname || ' (' || user_name || ')') as user_id, user_name, language_code, ESERV2_LANGUAGE_CODE from gets_lms_service_employee \n" +
"where language_code='SPN' and ESERV2_LANGUAGE_CODE!='SPN' and active_flag='YES'";
        
            
                
          

        
                 
    public void checkLanguage(){
        
        try{
           PreparedStatement prepStm = con.prepareStatement(myQuery);
           i=0;
           result="<table class=\"table table-striped\">"+        
                        "<tr>"+
				"<td style=\"border:3px solid black; background-color:buttonhighlight; color: blue\">User Name</td>"
                               + "<td style=\"border:3px solid black; background-color:buttonhighlight; color: blue\">eServices 1.0 Language</td>"
				+"<td style=\"border:3px solid black; background-color:buttonhighlight; color: blue\">eServices 2.0 Language</td>"
                                                           
			+"</tr>";
           script="<br>BEGIN <br>";
           ResultSet rs = prepStm.executeQuery();
           
                 if(rs.next()){
                     
                      do{                
                       user=rs.getString("user_id");
                       eserv1=rs.getString("language_code");
                       eserv2=rs.getString("ESERV2_LANGUAGE_CODE");
                       userName=rs.getString("user_name");
                       result+="<tr>"+            
                 
                               "<td style=\"border:2px solid black; background-color:aliceblue; color: black;\">"+user+"</td>"
                               + "<td style=\"border:2px solid black; background-color:aliceblue; color: black;\">"+eserv1+"</td>"
				+"<td style=\"border:2px solid black; background-color:aliceblue; color: black;\">"+eserv2+"</td>"
                                         
              
                            +"</tr>"   ;
                       script+="UPDATE gets_lms_service_employee <br>"
                               + " SET ESERV2_LANGUAGE_CODE='SPN' <br>"
                               + "where USER_NAME ='"+userName+"';<br>" ;

                       i++;   
                      }while (rs.next());
                       
                 }
                 
           script+="COMMIT;<br>END;   ";
           result+="</table>";
        }catch(SQLException e){}
    
    
    }

    /**
     * @return the result
     */
    public String getResult() {
        return result;
    }

    /**
     * @return the i
     */
    public int getI() {
        return i;
    }

    /**
     * @return the script
     */
    public String getScript() {
        return script;
    }
    
}
