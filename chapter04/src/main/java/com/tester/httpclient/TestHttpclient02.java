package com.tester.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

public class TestHttpclient02 {
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
    public void tets03() throws IOException {
     String url01 = this.url+this.bundle.getString("test.setCookie");
     HttpGet get = new HttpGet(url01);
     DefaultHttpClient client = new DefaultHttpClient();
     client.setCookieStore(this.store);
     HttpResponse res= client.execute(get);
     int statusCode = res.getStatusLine().getStatusCode();
        System.out.println(statusCode+"哈哈哈");
     if(statusCode == 200){
         System.out.println(EntityUtils.toString(res.getEntity()));
     }
    }
}
