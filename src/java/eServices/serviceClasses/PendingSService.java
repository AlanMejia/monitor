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
public class PendingSService implements Serializable {
  
    
      
       Connection con=OracleConnectionManager.getConnection(OracleConnectionManager.PROD); 
        
         private String result;
         String openTasks;
         String ssID;
         String ssComments;
         private int i;
         private String script;
        
       
        
          
           String myQuery = "select count(qa.service_sheet_id) as open_tasks, qa.service_sheet_id, ss.service_sheet_comments\n" +
"            from gets_lms_qa_results qa, gets_lms_service_sheet ss \n" +
"            where ss.service_sheet_id = qa.service_sheet_id \n" +
"            and qa.service_workorder_id in (select SERVICE_WORKORDER_ID from gets_lms_service_workorder where workorder_status_code not in (900))\n" +
"            and ss.service_sheet_status_code = 100\n" +
"            group by qa.service_sheet_id, ss.service_sheet_comments";
        
            
                
          

        
                 
    public void checkOpenTasks(){
        
        try{
           PreparedStatement prepStm = con.prepareStatement(myQuery);
           i=0;
           result="<br><br><table class=\"table table-striped\">"+        
                        "<tr>"+
				"<td style=\"border:3px solid black; background-color:buttonhighlight; color: blue\">Open Tasks</td>"
                               + "<td style=\"border:3px solid black; background-color:buttonhighlight; color: blue\">Service Sheet ID</td>"
				+"<td style=\"border:3px solid black; background-color:buttonhighlight; color: blue\">Service Sheet Comments</td>"
                                                   
                                
			+"</tr>";
           script="BEGIN";
           ResultSet rs = prepStm.executeQuery();
           
                 if(rs.next()){
                     
                      do{                
                       
                       openTasks=rs.getString("assignment_status");
                       ssID=rs.getString("service_sheet_status_code");
                       ssComments=rs.getString("service_sheet_comments");
                       result+="<tr>"+            
                 
                               "<td style=\"border:2px solid black; background-color:aliceblue; color: black;\">"+openTasks+"</td>"
                               + "<td style=\"border:2px solid black; background-color:aliceblue; color: black;\">"+ssID+"</td>"
				+"<td style=\"border:2px solid black; background-color:aliceblue; color: black;\">"+ssComments+"</td>"
      
                            +"</tr>"   ;
                       script+="<br>" +
"  UPDATE gets_fmi_loco_assign SET assignment_status = '900' where locomotive_id ="+ssID+" and fmi_id= "+ssID+";<br>";
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

   