package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.GetUserListCase;
import com.course.model.User;
import com.course.utils.DatabaseUtil;
import com.mysql.cj.xdevapi.JsonArray;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.List;

public class GetUserInfoListTest {



    @Test(dependsOnGroups="loginTrue",description = "获取性别为男的用户信息")
    public void getUserListInfo() throws Exception {
        SqlSession session = DatabaseUtil.getSession();
        GetUserListCase getUserListCase = session.selectOne("getUserListCase", 1);
        System.out.println(getUserListCase.toString());
        System.out.println(TestConfig.getUserListUrl);
        //模拟请求，获得实际结果
        JSONArray jsonValues = getJsonArrayResult(getUserListCase);
        //预期结果与实际结果比较
        List<User> user = session.selectList(getUserListCase.getExpected(),getUserListCase);
        JSONArray resultJson = new JSONArray(user);
        Assert.assertEquals(jsonValues.length(),resultJson.length());
        for(int i = 0;i < resultJson.length();i++){
            JSONObject a = (JSONObject)resultJson.get(i);
            JSONObject b = (JSONObject)jsonValues.get(i);
            Assert.assertEquals(a.toString(),b.toString());
        }

    }

    private JSONArray getJsonArrayResult(GetUserListCase getUserListCase) throws Exception {
        HttpPost post = new HttpPost(TestConfig.getUserListUrl);
        JSONObject param = new JSONObject();
        param.put("userName",getUserListCase.getUserName());
        param.put("sex",getUserListCase.getSex());
        param.put("age",getUserListCase.getAge());
        post.setHeader("content-Type","application/json");
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        TestConfig.defaultHttpClientConfig.setCookieStore(TestConfig.cookieStore);
        HttpResponse response = TestConfig.defaultHttpClientConfig.execute(post);
        String s = EntityUtils.toString(response.getEntity());
        JSONArray jsonArray = new JSONArray(s);
        return jsonArray;
    }

}
