package com.course.controller;
import com.course.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@Log4j
@RestController
@Api(value = "v1",description = "我的第一个查询demo")
@RequestMapping(value = "v1")
public class Demo {
    @Autowired
    private SqlSessionTemplate template;
    //新加的记录日志的类，不知道会不会报错
    final static Logger logger = LoggerFactory.getLogger(Demo.class);
    @RequestMapping(value = "/getUserC",method = RequestMethod.GET)
    @ApiOperation(value = "我的第一个查询demo",httpMethod = "GET")
    public int getUserCount(){
//        System.out.println("1111111111111111111111111111");
//        System.out.println(template);
//        System.out.println("2222222222222222222222222");
        return template.selectOne("getUserCount");
    }
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ApiOperation(value = "添加用户信息",httpMethod = "POST")
    public int addUser(@RequestBody User user){
            int res = this.template.insert("addUser",user);
            return res;
    }
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    @ApiOperation(value = "修改用户信息",httpMethod = "POST")
    public int updateUsre(@RequestBody User user){
        return this.template.update("updateUser",user);
    }
    @RequestMapping(value = "/deleteUser",method = RequestMethod.GET)
    @ApiOperation(value = "删除用户信息",httpMethod = "GET")
    public int deleteUser(@RequestParam int id){
        return this.template.delete("deleteUser",id);
    }
}
