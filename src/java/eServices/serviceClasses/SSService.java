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
public class SSService implements Serializable{
    Connection con=OracleConnectionManager.getConnection(OracleConnectionManager.PROD); 
        
         private String result;
         String woWO_ID;
         String ssWO_ID;
         String woLocoID;
         String ssLocoID;
         
         private int i;
         private String script;
        
       
        
          
           String myQuery = "select distinct ss.service_workorder_id as Service_Sheet_WO_ID,wo.service_workorder_id as Workorder_WO_ID,ss.locomotive_id as SS_loco_ID,\n" +
"wo.locomotive_id as WO_loco_ID\n" +
"from gets_lms_service_sheet ss, gets_lms_service_workorder wo \n" +
"where wo.locomotive_id!=ss.locomotive_id\n" +
"and wo.service_workorder_id=ss.service_workorder_id\n" +
"and wo.workorder_status_code not in (900)";
        
            
                
          

        
                 
    public void checkSS(){
        
        try{
           PreparedStatement prepStm = con.prepareStatement(myQuery);
           i=0;
           result="<br><br><table class=\"table table-striped\">"+        
                        "<tr>"+
				"<td style=\"border:3px solid black; background-color:buttonhighlight; color: blue\">Workorder_ID from SS</td>"
                               + "<td style=\"border:3px solid black; background-color:buttonhighlight; color: blue\">Workorder_ID from WO</td>"
				+"<td style=\"border:3px solid black; background-color:buttonhighlight; color: blue\">Locomotive_ID from SS</td>"
                               + "<td style=\"border:3px solid black; background-color:buttonhighlight; color: blue\">Locomotive_ID from WO</td>"
				
                              
                                
			+"</tr>";
           script="BEGIN";
           ResultSet rs = prepStm.executeQuery();
           
                 if(rs.next()){
                     
                      do{                
                       
                       ssWO_ID=rs.getString("Service_Sheet_WO_ID");
                       woWO_ID=rs.getString("Workorder_WO_ID");
                       ssLocoID=rs.getString("SS_loco_ID");
                       woLocoID=rs.getString("WO_loco_ID");
                       result+="<tr>"+            
                 
                               "<td style=\"border:2px solid black; background-color:aliceblue; color: black;\">"+ssWO_ID+"</td>"
                               + "<td style=\"border:2px solid black; background-color:aliceblue; color: black;\">"+woWO_ID+"</td>"
				+"<td style=\"border:2px solid black; background-color:aliceblue; color: black;\">"+ssLocoID+"</td>"
                               + "<td style=\"border:2px solid black; background-color:aliceblue; color: black;\">"+woLocoID+"</td>"
			                 
              
                            +"</tr>"   ;
                       script+="<br>" +
"  UPDATE gets_fmi_loco_assign SET assignment_status = '900' where locomotive_id ="+woLocoID+" and fmi_id= "+woLocoID+";<br>";
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

   