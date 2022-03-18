package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.InterfaceName;
import com.course.model.LoginCase;
import com.course.utils.ConfigFile;
import com.course.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class LoginTest {
    @BeforeTest(groups = "loginTrue",description = "测试准备工作前的一些赋值工作，比如URL、httpclient")
    public void beforeTest(){
        TestConfig.loginUrl = ConfigFile.getUrl(InterfaceName.LOGIN);
        TestConfig.addUserUrl = ConfigFile.getUrl(InterfaceName.ADDUSERINFO);
        TestConfig.getUserInfoUrl = ConfigFile.getUrl(InterfaceName.GETUSERINFO);
        TestConfig.getUserListUrl = ConfigFile.getUrl(InterfaceName.GETUSERLIST);
        TestConfig.updateUserInfoUrl = ConfigFile.getUrl(InterfaceName.UPDATEUSERINFO);
        TestConfig.defaultHttpClientConfig = new DefaultHttpClient();
    }
    @Test(groups = "loginTrue",description = "登录成功")
    public void testLoginTrue() throws Exception {
        SqlSession sqlSession = DatabaseUtil.getSession();
        LoginCase loginCase = sqlSession.selectOne("loginCase",1);
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginUrl);
        //模拟请求，获得响应结果
        String result = getResult(loginCase);
        //校验结果
        Assert.assertEquals(loginCase.getExpected(),result);
    }
    @Test(groups = "loginFalse",description = "登录失败")
    public void testLoginFalse() throws IOException {
        SqlSession sqlSession = DatabaseUtil.getSession();
        LoginCase loginCase = sqlSession.selectOne("loginCase",2);
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginUrl);
    }
    public String getResult(LoginCase loginCase) throws Exception {
        HttpPost post =new HttpPost(TestConfig.loginUrl);
        JSONObject object = new JSONObject();
        object.put("userName",loginCase.getUserName());
        //passWord测试字段名是否需要对应！！！！！！！！！！
        object.put("password",loginCase.getPassword());
        post.setHeader("Content-Type","Application/json");
        StringEntity entity = new StringEntity(object.toString(),"utf-8");
        post.setEntity(entity);
        HttpResponse response = TestConfig.defaultHttpClientConfig.execute(post);
//        System.out.println("333333333333333333333333");
          //这块取完以后，return就取不到了？？？？？
//        System.out.println(EntityUtils.toString(response.getEntity(),"utf-8"));
//        System.out.println("4444444444444444444444444");
        TestConfig.cookieStore = TestConfig.defaultHttpClientConfig.getCookieStore();
        return EntityUtils.toString(response.getEntity(),"utf-8");
    }
}
