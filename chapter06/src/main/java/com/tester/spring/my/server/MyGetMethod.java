package com.tester.spring.my.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value="/",description="所有的get方法")
public class MyGetMethod {
    @RequestMapping(value = "/cookiedemo",method = RequestMethod.GET)
    @ApiOperation(value="这是我返回cookie的get方法",httpMethod = "GET")
    public String getCookie(HttpServletResponse response){
        System.out.println("111111111111111111");
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        System.out.println("222222222222222222");
        return "恭喜成功！！！";
    }
    //携带cookie的get请求
    @RequestMapping(value = "/get/with/cookie",method = RequestMethod.GET)
    @ApiOperation(value="这是我携带cookie的get方法",httpMethod = "GET")
    public String getWithCookie(HttpServletRequest request){
        Cookie[] cookie1 =request.getCookies();
        if(Objects.isNull(cookie1)){
            return "没有携带cookie";
        }
        for (Cookie cookie:cookie1){
            if(cookie.getName().equals("login") && cookie.getValue().equals("true")){
                return "正确的携带cookie返回了！！！";
            }
        }
        return "没有携带cookie";
    }
    @RequestMapping(value="/get/with/para",method = RequestMethod.GET)
    @ApiOperation(value="这是我带参数的get方法1",httpMethod = "GET")
    public Map testGetWithParam(@RequestParam Integer start,
                                                    @RequestParam Integer end){
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("铅笔1",200);
        map.put("铅笔2",400);
        map.put("铅笔3",600);
        return map;
    }
    @RequestMapping(value = "/get/with/params/{start}/{end}",method = RequestMethod.GET)
    @ApiOperation(value="这是我带参数的get方法2",httpMethod = "GET")
    public Map testGetWithParam02(@PathVariable Integer start,
                                @PathVariable Integer end){
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("铅笔1",200);
        map.put("铅笔2",444);
        map.put("铅笔3",888);
        return map;
    }

}
