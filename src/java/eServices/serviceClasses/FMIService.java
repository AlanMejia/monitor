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
public class FMIService implements Serializable {
  
    
      
       Connection con=OracleConnectionManager.getConnection(OracleConnectionManager.PROD); 
        
         private String result;
         String fmiId;
         String lastUpdateDate;
         String locomotiveId;
         String assignmentStatus;
         String ssComments;    
         String ssStatusCode;
         String woNumber;
         private int i;
         private String script;
        
       
        
          
           String myQuery = "select assign.fmi_id, assign.last_update_date,ss.service_sheet_status_code,assign.assignment_status, loco.locomotive_id, \n" +
"  ss.service_sheet_comments, wo.workorder_number\n" +
"    from gets_lms_locomotive_all  loco, gets_fmi_loco_assign  assign, gets_lms_service_sheet ss, gets_lms_service_workorder wo\n" +
"    where loco.locomotive_status_code='ACTIVE'\n" +
"    and assign.locomotive_id=loco.locomotive_id\n" +
"    and ss.fmi_id = assign.fmi_id\n" +
"    and loco.locomotive_id = ss.locomotive_id\n" +
"    and ss.profile_id = assign.profile_id \n" +
"    and wo.service_workorder_id = assign.service_workorder_id\n" +
"    and workorder_status_code not in (900)\n" +
"    and assign.assignment_status != ss.service_sheet_status_code";
        
            
                
          

        
                 
    public void checkFMI(){
        
        try{
           PreparedStatement prepStm = con.prepareStatement(myQuery);
           i=0;
           result="<br><br><table class=\"table table-striped\">"+        
                        "<tr>"+
				"<td style=\"border:3px solid black; background-color:buttonhighlight; color: blue\">FMI ID</td>"
                               + "<td style=\"border:3px solid black; background-color:buttonhighlight; color: blue\">FMI Number</td>"
				+"<td style=\"border:3px solid black; background-color:buttonhighlight; color: blue\">LastUpdateDate</td>"
                               + "<td style=\"border:3px solid black; background-color:buttonhighlight; color: blue\">Locomotive ID</td>"
				+"<td style=\"border:3px solid black; background-color:buttonhighlight; color: blue\">LocoAssign Status</td>"
                               + "<td style=\"border:3px solid black; background-color:buttonhighlight; color: blue\">ServiceSheet Status</td>"
                               + "<td style=\"border:3px solid black; background-color:buttonhighlight; color: blue\">Workorder Number</td>"
                              
                                
			+"</tr>";
           script="BEGIN";
           ResultSet rs = prepStm.executeQuery();
           
                 if(rs.next()){
                     
                      do{                
                       
                       assignmentStatus=rs.getString("assignment_status");
                       ssStatusCode=rs.getString("service_sheet_status_code");
                       locomotiveId=rs.getString("locomotive_id");
                       woNumber=rs.getString("workorder_number");
                       fmiId=rs.getString("fmi_id");
                       lastUpdateDate=rs.getString("last_update_date");
                       ssComments=rs.getString("service_sheet_comments");
                       result+="<tr>"+            
                 
                               "<td style=\"border:2px solid black; background-color:aliceblue; color: black;\">"+fmiId+"</td>"
                               + "<td style=\"border:2px solid black; background-color:aliceblue; color: black;\">"+ssComments+"</td>"
				+"<td style=\"border:2px solid black; background-color:aliceblue; color: black;\">"+lastUpdateDate+"</td>"
                               + "<td style=\"border:2px solid black; background-color:aliceblue; color: black;\">"+locomotiveId+"</td>"
			       + "<td style=\"border:2px solid black; background-color:aliceblue; color: black;\">"+assignmentStatus+"</td>"
                               + "<td style=\"border:2px solid black; background-color:aliceblue; color: black;\">"+ssStatusCode+"</td>"
                                + "<td style=\"border:2px solid black; background-color:aliceblue; color: black;\">"+woNumber+"</td>"              
              
                            +"</tr>"   ;
                       script+="<br>" +
"  UPDATE gets_fmi_loco_assign SET assignment_status = '900' where locomotive_id ="+locomotiveId+" and fmi_id= "+fmiId+";<br>";
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

   