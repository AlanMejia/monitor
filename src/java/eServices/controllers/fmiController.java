
package eServices.controllers;

import eServices.serviceClasses.FMIService;
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
public class fmiController {
    @Autowired //for dependency injection
    
       FMIService fmisrv=new FMIService();     
            
    
    @RequestMapping("/controller/FMIController.do")
    protected ModelAndView mainController(HttpServletRequest request, HttpServletResponse response){
        
        
         fmisrv.checkFMI();
                
        ModelAndView model =new ModelAndView ("/fmi"); //direccion de la vista
        String result=fmisrv.getResult();
        int counter=fmisrv.getI();
        String script=fmisrv.getScript();
        model.addObject("result",result);
        model.addObject("counter",counter);
        model.addObject("script",script);
        
      //String FMINumber=request.getParameter("fmi_number").trim();
       
        return model;
        }
    
}
