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
public class TasksService implements Serializable{
    
    
     Connection con=OracleConnectionManager.getConnection(OracleConnectionManager.PROD); 
        
         private String result;         
         String woID;
         String taskNumber;
         String planDesc;         
         String ssId;
         String woNumber;
         private int i;
         
         
        
       
        
          
           String myQuery =  "select qa.service_workorder_id,"+ 
"(select workorder_number from gets_lms_service_workorder where service_workorder_id = qa.service_workorder_id) as workorder_number,"+
"qa.task_number, qa.service_sheet_id, qa.plan_description from gets_lms_qa_results qa, getS_lms_qa_chars cha where "+
                "qa.char_id = cha.char_id "+
                "AND qa.service_Workorder_id in (select service_workorder_id from gets_lms_service_workorder where workorder_status_code=300)"+
                "and qa.column_value is null "+
                "and qa.performed_flag = 'Y' "+
                "and (cha.char_type_code = 'VARIABLE' or cha.char_type_code = 'LOV') order by plan_description asc";
        
            
                
          

        
                 
    public void checkTasks(){
        
        try{
           PreparedStatement prepStm = con.prepareStatement(myQuery);
           result="<br><br><table class=\"table table-striped\">"+        
                        "<tr>"+
				"<td style=\"border:3px solid black; background-color:buttonhighlight; color: blue\">Workorder ID</td>"
                               + "<td style=\"border:3px solid black;  background-color:buttonhighlight; color: blue\">Workorder Number</td>"
				+"<td style=\"border:3px solid black;  background-color:buttonhighlight; color: blue\">Task Number</td>"
                               + "<td style=\"border:3px solid black;  background-color:buttonhighlight; color: blue\">Plan Description</td>"
				+"<td style=\"border:3px solid black;  background-color:buttonhighlight; color: blue\">Service Sheet ID</td>"                                                        
                                
			+"</tr>";
           i=0;
           ResultSet rs = prepStm.executeQuery();
           
                 if(rs.next()){
                     
                        
                      do{  
                          
                       
                       woID=rs.getString("service_workorder_id");
                       woNumber=rs.getString("workorder_number");
                       taskNumber=rs.getString("task_number");
                       planDesc=rs.getString("plan_description");
                       ssId=rs.getString("service_sheet_id");
                       
                      
                       result+="<tr>"+            
                 
                               "<td style=\"border:2px solid black; background-color:aliceblue; color: black;\">"+woID+"</td>"
                               + "<td style=\"border:2px solid black; background-color:aliceblue; color: black;\">"+woNumber+"</td>"
				+"<td style=\"border:2px solid black; background-color:aliceblue; color: black;\">"+taskNumber+"</td>"
                               + "<td style=\"border:2px solid black; background-color:aliceblue; color: black;\">"+planDesc+"</td>"
			       + "<td style=\"border:2px solid black; background-color:aliceblue; color: black;\">"+ssId+"</td>"
                               
                            +"</tr>"   ;
                       i++;   
                       
                      }while (rs.next());
                      
                      
                 }
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
    
    
    
}
