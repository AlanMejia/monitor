package dummy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    String flagService="";
   

    @RequestMapping("/Flag")
    public String greeting() {
        if (HelloController.flag.equals("Turn On Device")){
            flagService="ON";
        }else flagService="OFF";
        
        return flagService;
    }
}