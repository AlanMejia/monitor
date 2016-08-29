package dummy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.annotation.Secured;



@RestController
public class FlagController {
    
    private String flagService;
    
	
	@Secured("ROLE_ADMIN")
    @RequestMapping("/Flag")
    public String greeting() {
        if (AppController.flag.getFlag().equals("Turn On Device")){
            flagService="ON";
        }else flagService="OFF";
        
        return flagService;
    }
}