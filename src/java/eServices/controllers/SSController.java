/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eServices.controllers;


import eServices.serviceClasses.SSService;
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
public class SSController {
    @Autowired //for dependency injection
    
       SSService ssrv=new SSService();     
            
    
    @RequestMapping("/controller/ServiceSheetController.do")
    protected ModelAndView mainController(HttpServletRequest request, HttpServletResponse response){
        
        
         ssrv.checkSS();
                
        ModelAndView model =new ModelAndView ("/SSbad"); //direccion de la vista
        String result=ssrv.getResult();
        int counter=ssrv.getI();
        String script=ssrv.getScript();
        model.addObject("result",result);
        model.addObject("counter",counter);
        model.addObject("script",script);
        

       
        return model;
        }
    
}
