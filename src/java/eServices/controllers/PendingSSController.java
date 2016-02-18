/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eServices.controllers;


import eServices.serviceClasses.PendingSService;
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
public class PendingSSController {
    
@Autowired //for dependency injection
    
       PendingSService srv=new PendingSService();     
            
    
    @RequestMapping("/controller/OpenTasks.do")
    protected ModelAndView mainController(HttpServletRequest request, HttpServletResponse response){
        
        
         srv.checkOpenTasks();
                
        ModelAndView model =new ModelAndView ("/openTasks"); //direccion de la vista
        String result=srv.getResult();
        int counter=srv.getI();
        String script=srv.getScript();
        model.addObject("result",result);
        model.addObject("counter",counter);
        model.addObject("script",script);
        
      
       
        return model;
        }
    
}

