package dummy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class FlagController {
    
    private String flagService;
    
	
    @RequestMapping("/Flag")
    public String greeting() {
        if (AppController.flag.getFlag().equals("Turn On Device")){
            flagService="ON";
        }else flagService="OFF";
        
        return flagService;
    }
}