/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eServices.controllers;


import eServices.serviceClasses.MaterialsService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author 779609
 */
@Controller
public class MaterialsController {
    @Autowired //for dependency injection
    
       MaterialsService matsrv=new MaterialsService();     
            
    
    @RequestMapping("/controller/OracleMaterials.do")
    protected ModelAndView mainController(HttpServletRequest request, HttpServletResponse response){
        
        
         matsrv.checkMaterials();
                
        ModelAndView model =new ModelAndView ("/materials"); //direccion de la vista
        String result=matsrv.getResult();
        int counter=matsrv.getI();
        model.addObject("result",result);
        model.addObject("counter",counter);
        
      //String FMINumber=request.getParameter("fmi_number").trim();
       
        return model;
        }
    
}
