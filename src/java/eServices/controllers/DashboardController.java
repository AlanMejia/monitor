/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eServices.controllers;

import eServices.serviceClasses.DashboardService;
import eServices.serviceClasses.FMIService;
import eServices.serviceClasses.LanguageService;
import eServices.serviceClasses.MaterialsService;
import eServices.serviceClasses.PendingSService;
import eServices.serviceClasses.SSService;
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
public class DashboardController {
    
    @Autowired //for dependency injection
    
           DashboardService dash=new DashboardService();
    
    @RequestMapping("/controller/Dashboard.do")
    protected ModelAndView mainController(HttpServletRequest request, HttpServletResponse response){
        ModelAndView model =new ModelAndView ("/monitorDashboard"); //direccion de la vista
       
        dash.getDashboard();
        
        //for FMI mismatches             
        model.addObject("fmiResult",dash.getFmiResult());
        model.addObject("fmiScript", dash.getFmiScript());
        model.addObject("fmiCount", dash.getFmiCount());
         //for tasks without values        
        model.addObject("tasksResult", dash.getTasksResult());
        model.addObject("tasksCount", dash.getTasksCount());
        //for Service Sheets with wrong locomotive id        
        model.addObject("SSResult",dash.getSheetResult());
        model.addObject("SSScript", dash.getSheetScript());
        model.addObject("SSCount", dash.getSheetCount());
        //for pending service sheets that are still attached
        model.addObject("pendResult",dash.getPendResult());
        model.addObject("pendScript", dash.getPendScript());
        model.addObject("pendCount", dash.getPendCount());
        //for Materials in oracle missing service sheet
         model.addObject("matResult",dash.getMatResult());
         model.addObject("matCount", dash.getMatCount());
        //for checking spanish users in 2.0
        model.addObject("lanResult",dash.getLanResult());
        model.addObject("lanScript", dash.getLanScript());
        model.addObject("lanCount", dash.getLanCount());
       
        
        
        return model;
        }
    
}

    
    
    

