package dummy;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.access.annotation.Secured;

@Controller
public class HelloController {

	@Value("${application.message:Hello Roxannita Guapa}")
	private String message = "Hello Roxannita Guapa";
    public static String flag="";
    private String flag2="";
    
    
    
	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", this.message);
		return "welcome";
	}
	
	
	   @Secured(ROLE_ADMIN)
	   @RequestMapping("/Switch")
	    protected ModelAndView mainController(HttpServletRequest request, HttpServletResponse response){
    	 ModelAndView model =new ModelAndView ("/SwitchFile"); //direccion de la vista
    	    
    	    flag2=flag;
    	    
    	    try{
                flag=request.getParameter("on").toString();
    	       }catch(Exception ex){flag=flag2;}
    	       
    	       
            
        	model.addObject("req", flag);
        	return model;
               }
		
	


}