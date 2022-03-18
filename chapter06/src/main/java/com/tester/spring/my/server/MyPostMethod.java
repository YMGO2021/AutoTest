package com.tester.spring.my.server;

import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;
import com.tester.spring.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/",description = "我所有的post接口")
@RequestMapping("/v1")
public class MyPostMethod {
    private Cookie cookie;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "带参数的post请求",httpMethod = "POST")
    public String testPostWithPara(HttpServletResponse response, @RequestParam(value="userName",required = true) String userName,
                                   @RequestParam(value="passWord",required = true) String passWord){
        if(userName.equals("zhangsan") && passWord.equals("123456")){
            Cookie c = new Cookie("login","true");
            this.cookie = c;
            response.addCookie(c);
            return "登录成功了！！！";
        }
        return "登录失败了！！！！";
    }
    @RequestMapping(value = "/testPost",method = RequestMethod.POST)
    @ApiOperation(value = "返回用户列表",httpMethod = "POST")
   public String testPost(HttpServletRequest request, @RequestBody User user){
        Cookie[] cookies = request.getCookies();
        User u = new User();
        for(Cookie c : cookies){
            if(c.getName().equals("login") && c.getValue().equals("true")){
              u.setName("zhangsan");
              u.setAge("10");
              return u.toString();
            }
        }

        return "cookie验证失败，返回列表失败！！！";
   }
}
