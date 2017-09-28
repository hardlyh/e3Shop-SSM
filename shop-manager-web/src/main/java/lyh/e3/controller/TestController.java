package lyh.e3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    
    
    @RequestMapping("/test/test1")
    @ResponseBody
    public String test(){
       return "ssss"; 
    }

}
