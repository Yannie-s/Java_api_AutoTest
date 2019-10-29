package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//springboot demo http://localhost:8080/ 输入此即可页面出现hello world字样
@Controller
@EnableAutoConfiguration
public class SamplerControl {
    @RequestMapping("/")
    @ResponseBody
    String home(){
        return "hello world";
    }
    public static void main(String[] args) throws Exception{
        SpringApplication.run(SamplerControl.class,args);
    }
}
