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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;

@Controller
public class AppController {


    public static FlagObject flag;
    
    
     @Autowired
    public AppController(FlagObject obj){
        this.flag=obj;
    }
   
    
	@Secured("ROLE_ADMIN")
	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("time", new Date());
		return "welcome";
	}
	
	
    @Secured("ROLE_ADMIN")
	@RequestMapping("/Switch")
    protected ModelAndView mainController(HttpServletRequest request, HttpServletResponse response){
    	
    	 ModelAndView model =new ModelAndView ("/SwitchFile"); //direccion de la vista
    	 flag.setFlag(request.getParameter("on").toString());
    	 model.addObject("req", flag.getFlag());
        	return model;
    }
		
	


}