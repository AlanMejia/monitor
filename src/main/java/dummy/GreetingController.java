package dummy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

   

    @RequestMapping("/Flag")
    public String greeting() {
        return HelloController.flag;
    }
}