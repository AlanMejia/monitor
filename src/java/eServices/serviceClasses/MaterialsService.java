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
public class MaterialsService implements Serializable {
  
    
      
       Connection con=OracleConnectionManager.getConnection(OracleConnectionManager.PROD); 
        
         private String result;
         String part;
         String woID;
         String woNumber;
         String SSO;
         String email;    
         String createdBy;
         String name;
         private int i;
        
       
        
          
           String myQuery = "select (select distinct segment1 from GETS_INTF_MTL_SYS_ITEMS_B where inventory_item_id = mat.inventory_item_id) as picked_part,\n" +
"  ee.employee_firstname, wo.service_workorder_id,wo.workorder_number, ee.user_name,NVL( ee.employee_email,ee.user_name) as User_email,\n" +
"  (select employee_firstname || ' ' || employee_lastname || ' (' || user_name || ')' from gets_lms_service_employee where user_id = mat.created_by) as created_by_user\n" +
"    from gets_lms_material_usage mat, gets_lms_service_workorder wo,gets_lms_service_employee ee\n" +
"where mat.service_workorder_id = wo.service_workorder_id\n" +
"and mat.last_updated_by=ee.user_id\n" +
"and wo.workorder_status_code <> 900\n" +
"and mat.service_sheet_id is null\n" +
"and mat.shopping_cart_detail_id is null\n" +
"and wo.customer_id <> 1258\n" +
"and mat.quantity <> 0\n" +
"and upper(wo.workorder_number) not like '%SALES%'";
        
            
                
          

        
                 
    public void checkMaterials(){
        
        try{
           PreparedStatement prepStm = con.prepareStatement(myQuery);
           i=0;
           result="<table class=\"table table-striped\">"+        
                        "<tr>"+
				"<td style=\"border:3px solid black; background-color:buttonhighlight; color: blue\">Part Number</td>"
                               + "<td style=\"border:3px solid black; background-color:buttonhighlight; color: blue\">Workorder ID</td>"
				+"<td style=\"border:3px solid black; background-color:buttonhighlight; color: blue\">Workorder Number</td>"
                               + "<td style=\"border:3px solid black; background-color:buttonhighlight; color: blue\">User SSO</td>"
				+"<td style=\"border:3px solid black; background-color:buttonhighlight; color: blue\">User eMail</td>"
                               + "<td style=\"border:3px solid black; background-color:buttonhighlight; color: blue\">Created by User</td>"
                                                 
			+"</tr>";
           ResultSet rs = prepStm.executeQuery();
           
                 if(rs.next()){
                     
                      do{                
                       
                       part=rs.getString("picked_part");
                       woID=rs.getString("service_workorder_id");
                       woNumber=rs.getString("workorder_number");
                       SSO=rs.getString("user_name");
                       email=rs.getString("user_email");
                       createdBy=rs.getString("created_by_user");
                       name=rs.getString("employee_firstname");
                       result+="<tr>"+            
                 
                               "<td style=\"border:2px solid black; background-color:aliceblue; color: black;\">"+part+"</td>"
                               + "<td style=\"border:2px solid black; background-color:aliceblue; color: black;\">"+woID+"</td>"
				+"<td style=\"border:2px solid black; background-color:aliceblue; color: black;\">"+woNumber+"</td>"
                               + "<td style=\"border:2px solid black; background-color:aliceblue; color: black;\">"+SSO+"</td>"
			       + "<td style=\"border:2px solid black; background-color:aliceblue; color: black;\">"+email+"</td>"
                               + "<td style=\"border:2px solid black; background-color:aliceblue; color: black;\">"+createdBy+"</td>"
                               +"<td><a href=\"mailto:"+email+"?subject=Please assign a Service Sheet to Material in Workorder "+woNumber+" &body=Hello "+name+", good day! %0D%0A %0D%0ACan you please help us assigning a Service Sheet to Material number "+part+" in workorder "+woNumber+"? %0D%0APlease let us know in case of any concern.%0D%0A%0D%0AThanks in advance!&cc=eServicesSupportTeam@Trans.ge.com\">Send eMail</a></td>"
              
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

   