package dummy;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {

	@Value("${application.message:Hello Roxannita Guapa}")
	private String message = "Hello Roxannita Guapa";
    private String switchFlag;
    
	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", this.message);
		return "welcome";
	}
	
	@RequestMapping("/ON")
       public String switchOn(Map<String, Object> model) {
       	     	switchFlag="ON";
				model.put("switchFlag", this.switchFlag);
			    return "SwitchFile";
	}
	
		@RequestMapping("/OFF")
       public String switchOff(Map<String, Object> model) {
             	switchFlag="OFF";
				model.put("switchFlag", this.switchFlag);
			    return "SwitchFile";
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