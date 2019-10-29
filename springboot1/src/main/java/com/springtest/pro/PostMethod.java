package com.springtest.pro;

import com.springtest.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value="/",description="这是所有的post接口")
@RequestMapping("/vo")
public class PostMethod {
    @RequestMapping(value="/login",method= RequestMethod.POST)
    @ApiOperation(value="登陆接口，成功获取cookies信息")
    public String login(HttpServletResponse response,
                        @RequestParam(value="userName",required=true) String userName,
                        @RequestParam(value="password",required=true) String password){
        if(userName.equals("zhang")&&password.equals("123")){
            Cookie cookie=new Cookie("login","true");
            response.addCookie(cookie);
            return "成功登陆";
    }
        return "用户名或密码错误";

    }
    @RequestMapping(value="/getUserList",method=RequestMethod.POST)
    @ApiOperation(value="获取用户列表",httpMethod="POST")
    public String getUserList(HttpServletRequest request,@RequestBody User u){
        User user;
        Cookie[] cookies=request.getCookies();
        for(Cookie c:cookies){
            if(c.getName().equals("login")&&c.getValue().equals("true")
            &&u.getUserName().equals("zhang")
            &&u.getPassword().equals("123")){
                user=new User();
                user.setName("li");
                user.setAge("18");
                user.setSex("man");
                return user.toString();
            }
        }
        return "参数不合法";
    }
}
