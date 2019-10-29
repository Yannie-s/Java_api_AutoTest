package com.springtest.pro;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value="/",description = "这是我全部的get接口文档")
public class GetMethod {
    @RequestMapping(value = "/getcookies",method =RequestMethod.GET)
    @ApiOperation(value="通过此方法获取cookies",httpMethod="GET")
    public String getcookies(HttpServletResponse response){
        Cookie cookie =new Cookie("login","name");
        response.addCookie(cookie);
        return "返回了cookies";
    }
    /* 携带cookies信息才可以访问的get请求接口*/
    @RequestMapping( value="/get/with/cookies",method=RequestMethod.GET)
    @ApiOperation(value="通过此方法携带cookie get请求",httpMethod="GET")
    public String getwithcookie(HttpServletRequest request){
        Cookie[] cookies=request.getCookies();
        if(Objects.isNull(cookies)){
            return "没有携带cookies无法访问";
        }
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("login")&&cookie.getValue().equals("name")){
                return "携带cookie且正确 访问成功";
            }
        }
        return "必须携带cookie";
    }
    /*第一种需携带参数的get请求接口开发*/
    @RequestMapping(value="/get/with/param",method=RequestMethod.GET)
   @ApiOperation(value="需携带参数的第一种get请求",httpMethod = "GET")
    public Map<String,Integer> getPara(@RequestParam Integer star, @RequestParam Integer end){
        Map<String,Integer> myList=new HashMap<>();
        myList.put("鞋",300);
        myList.put("面",1);
        myList.put("衬衫",200);
        return myList;
    }
    /*第二种携带参数的get请求接口开发*/
    @RequestMapping(value = "/get/with/param/{star}/{end}")
   @ApiOperation(value = "需携带参数的第二种get请求",httpMethod="GET")
    public  Map getp(@PathVariable Integer star,@PathVariable Integer end){
        Map<String,Integer> myList=new HashMap<>();
        myList.put("鞋",300);
        myList.put("面",1);
        myList.put("衬衫",200);
        return myList;
    }

}
