package com.course.cases;


import com.course.config.TestConfig;
import com.course.model.AddUserCase;
import com.course.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddUserTest {
    @Test(dependsOnGroups = "loginTrue",description = "添加用户接口接口")
    public void addUser() throws IOException, InterruptedException {
        SqlSession session = DatabaseUtil.getSession();
        AddUserCase addUserCase = session.selectOne("addUserCase",1);
        System.out.println(addUserCase.toString());
        System.out.println(TestConfig.addUserUrl);
        //模拟请求，获得响应结果
        System.out.println("111111111111111111111111");
        String result = getResult(addUserCase);
        System.out.println("22222222222222222222222222222");

        //校验结果
        Assert.assertEquals(addUserCase.getExpected(),result);
    }
    public String getResult(AddUserCase addUserCase) throws IOException {
       HttpPost post = new HttpPost(TestConfig.addUserUrl);
       post.setHeader("Content-Type","Application/json");
       JSONObject param = new JSONObject();
        param.put("userName",addUserCase.getUserName());
        param.put("password",addUserCase.getPassword());
        param.put("sex",addUserCase.getSex());
        param.put("age",addUserCase.getAge());
        param.put("permission",addUserCase.getPermission());
        param.put("isDelete",addUserCase.getIsDelete());
        StringEntity entity = new StringEntity(param.toString());
        post.setEntity(entity);
        TestConfig.defaultHttpClientConfig.setCookieStore(TestConfig.cookieStore);
        HttpResponse response = TestConfig.defaultHttpClientConfig.execute(post);
        return EntityUtils.toString(response.getEntity());
    }


}
