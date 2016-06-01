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

@Controller
public class HelloController {

	@Value("${application.message:Hello Roxannita Guapa}")
	private String message = "Hello Roxannita Guapa";
    private String flag="";
    private String flag2="";
    
    
	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", this.message);
		return "welcome";
	}
	
	   @RequestMapping("/Switch")
	    protected ModelAndView mainController(HttpServletRequest request, HttpServletResponse response){
    	 ModelAndView model =new ModelAndView ("/SwitchFile"); //direccion de la vista
    	    
    	    if (!"".equals(request.getParameter("on").toString())){
                flag=request.getParameter("on").toString();
    	       }
            
        	model.addObject("req", flag);
        	return model;
        }
		
	
	@RequestMapping("/hi")
	public String hi() {
		
		return "Welcome from spring boot";
	}

	@RequestMapping("/foo")
	public String foo(Map<String, Object> model) {
		throw new RuntimeException("Foo");
	}

}