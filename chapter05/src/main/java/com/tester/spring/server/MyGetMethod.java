package com.tester.spring.server;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
@RestController
public class MyGetMethod {
    @RequestMapping(value = "/cookiedemo",method = RequestMethod.GET)
    public String getCookie(HttpServletResponse response){
        System.out.println("111111111111111111");
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        System.out.println("222222222222222222");
         return "恭喜成功！！！99999999999999";
    }
}
