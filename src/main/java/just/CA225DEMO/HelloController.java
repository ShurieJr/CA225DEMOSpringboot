package just.CA225DEMO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@RestController
@Controller
public class HelloController {

    //@GetMapping("/")
    @RequestMapping(method = RequestMethod.GET , path = "/")
    @ResponseBody
    public String show(){
        return "Welcome to spring boot!";
    }
    @RequestMapping(method = RequestMethod.GET , path = "/java")
    @ResponseBody
    public String test(){
        return "Welcome to java!";
    }
}
