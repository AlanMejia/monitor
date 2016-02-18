/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eServices.serviceClasses;

import java.io.Serializable;
import java.sql.Connection;
import misc.OracleConnectionManager;
import org.springframework.stereotype.Service;

/**
 *
 * @author 779609
 */
@Service
public class MainService implements Serializable{
    
    public String getMainMessage(){
        Connection con=OracleConnectionManager.getConnection(OracleConnectionManager.PROD); 
        if (con == null) {
          
          return "Connection couldn´t be established";
        }  else{   
        return "Succesfully Connected to DB";}

}
    
    
    
}
