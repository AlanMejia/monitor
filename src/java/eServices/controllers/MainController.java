/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eServices.controllers;

import eServices.serviceClasses.MainService;
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
public class MainController {
    @Autowired //for dependency injection
    
            MainService mainsrv;
    
    @RequestMapping("/controller/ShowMainController.do")
    protected ModelAndView mainController(HttpServletRequest request, HttpServletResponse response){
        ModelAndView model =new ModelAndView ("/MainPage"); //direccion de la vista
        model.addObject("message",mainsrv.getMainMessage());
        return model;
        }
    
}
