package com.tester.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestHttpclient01 {
    @Test
    public void test01() throws IOException {
     String result = "";
        //创建get方法
        HttpGet get = new HttpGet("https://www.baidu.com/");
        //获得客户端
        HttpClient c = new DefaultHttpClient();
        //执行get
        HttpResponse res = c.execute(get);
        //获得相应体
        HttpEntity e = res.getEntity();
        //将结果转化成String
//        result = EntityUtils.toString(e,defaultCharset="UTF-8");
        result = EntityUtils.toString(e);
        System.out.println(result);

    }
}
