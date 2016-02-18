/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eServices.controllers;

/**
 *
 * @author 779609
 */

import eServices.serviceClasses.LanguageService;
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
public class LanguageController {
    @Autowired //for dependency injection
    
       LanguageService lansrv=new LanguageService();     
            
    
    @RequestMapping("/controller/eServicesLanguage.do")
    protected ModelAndView mainController(HttpServletRequest request, HttpServletResponse response){
        
        
         lansrv.checkLanguage();
                
        ModelAndView model =new ModelAndView ("/language"); //direccion de la vista
        String result=lansrv.getResult();
        int counter=lansrv.getI();
        String script=lansrv.getScript();
        model.addObject("result",result);
        model.addObject("counter",counter);
        model.addObject("script",script);
        
     
       
        return model;
        }
    
}
