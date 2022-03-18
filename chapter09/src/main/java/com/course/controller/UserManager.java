package com.course.controller;

import com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

@RestController
@Log4j
@Api(value = "/v1",description = "我的用户管理类")
@RequestMapping(value = "/v1")
public class UserManager {
    @Autowired
    private  SqlSessionTemplate sqlSessionTemplate;
    //用户登录
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "用户登录接口",httpMethod = "POST")
    public Boolean userLogin(HttpServletResponse response, @RequestBody User user){
        int result = sqlSessionTemplate.selectOne("login",user);
        if(result == 1){
            Cookie cookie = new Cookie("login","true");
            response.addCookie(cookie);
            log.info("用户登录成功了！！"+result);
            return true;
        }else {
            log.info("用户登录失败！！");
            return false;
        }

    }
    //查询用户信息
    @RequestMapping(value = "/getUserInfo",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户详情",httpMethod = "POST")
    public  List<User>  getUserInfo(@RequestBody User user, HttpServletRequest request){
        Boolean result = verifyCookies(request);
        List<User> resUser = null;
        if(result){
            resUser = sqlSessionTemplate.selectList("getUserInfo",user);
        }
        return resUser;
    }
    //添加用户信息
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ApiOperation(value = "添加用户信息",httpMethod = "POST")
    public Boolean addUser(@RequestBody User user,HttpServletRequest request){
        Boolean result = verifyCookies(request);
        Boolean res = false;
        if(result){
         int i = sqlSessionTemplate.insert("addUser",user);
           if(i > 0){
               res = true;
           }

        }
        return res;
    }
    //修改用户信息
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    @ApiOperation(value = "修改用户信息",httpMethod = "POST")
    public int updateUser(HttpServletRequest request,@RequestBody User user){
        boolean result = verifyCookies(request);
        int res = 0;
        if(result){
            res = sqlSessionTemplate.update("updateUser",user);
            return res;
        }
        return res;
    }
    //验证cookie信息
    public boolean verifyCookies (HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(Objects.isNull(cookies)){
            return false;
        }
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("login") && cookie.getValue().equals("true")){
                return true;
            }
        }
             return false;
    }
}
