/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eServices.controllers;


import eServices.serviceClasses.TasksService;
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
public class TasksController {
    @Autowired //for dependency injection
    
            TasksService tasksrv=new TasksService();
            
    
    @RequestMapping("/controller/Tasks.do")
    protected ModelAndView mainController(HttpServletRequest request, HttpServletResponse response){
      
        tasksrv.checkTasks();
                
        ModelAndView model =new ModelAndView ("/tasks"); //direccion de la vista
        String result=tasksrv.getResult();
        int counter=tasksrv.getI();
        model.addObject("result",result);
        model.addObject("counter",counter);
        
      //String FMINumber=request.getParameter("fmi_number").trim();
       
        return model;
        }
    
    
}
