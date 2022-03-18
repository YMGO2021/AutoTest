package com.tester.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

public class TestPostCookie {
    private String url;
    private ResourceBundle bundle;
    private CookieStore store;
    @BeforeMethod
    public void test01(){
        bundle = ResourceBundle.getBundle("application");
        url = bundle.getString("test.url");
    }
    @Test
    public void test02() throws IOException {
        String url = "";
        url = this.url+this.bundle.getString("test.getCookie");
        HttpGet get = new HttpGet(url);
        //要获得getCookieStore的话，必须是要DefaultHttpClient
        DefaultHttpClient c = new DefaultHttpClient();
//        HttpClient c = new DefaultHttpClient();
        HttpResponse res = c.execute(get);
        String resuit = EntityUtils.toString(res.getEntity());
        System.out.println(resuit);
        this.store = c.getCookieStore();
        List<Cookie> list = this.store.getCookies();
        for(Cookie cookie:list){
            System.out.println("name--------->"+cookie.getName());
            System.out.println("Value--------->"+cookie.getValue());
        }
    }
    @Test(dependsOnMethods = "test02")
    public void testPost() throws Exception {
        String url = this.url+this.bundle.getString("test.getPost");
        System.out.println(url+"00000000000000000");
        DefaultHttpClient client = new DefaultHttpClient();
        client.setCookieStore(this.store);
        HttpPost post = new HttpPost(url);
//        post.setHeader("Content-Type","Application");
        JSONObject json = new JSONObject();
        json.put("name","zhangsan");
        json.put("age","18");
        StringEntity entity = new StringEntity(json.toString());
        post.setEntity(entity);
        HttpResponse res = client.execute(post);
        String result = EntityUtils.toString(res.getEntity());
        res.getStatusLine().getStatusCode();
        System.out.println(res.getStatusLine().getStatusCode()+"呵呵呵呵额");
        JSONObject ret = new JSONObject(result);
        Assert.assertEquals("6666",ret.get("name"));
        Assert.assertEquals("22",ret.get("age"));
    }
}
