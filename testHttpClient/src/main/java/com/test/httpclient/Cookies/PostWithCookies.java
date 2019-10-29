package com.test.httpclient.Cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.helper.HttpConnection;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class PostWithCookies {
    private String url;
    private ResourceBundle bundle=ResourceBundle.getBundle("application", Locale.CHINA);
    private CookieStore store;
    @BeforeTest
    public void test00(){
      url=bundle.getString("test.url");
    }

    @Test
    public void test01() throws IOException {
        String urll=bundle.getString("getCookies.url");
        String testurl=this.url+urll;
        HttpGet get=new HttpGet(testurl);
        DefaultHttpClient client=new DefaultHttpClient();
        this.store=client.getCookieStore();
        List<Cookie> cook=store.getCookies();
        for (Cookie cookie:cook){
            String name=cookie.getName();
            String value=cookie.getValue();
        }
        HttpResponse response01=client.execute(get);
        String ress=EntityUtils.toString(response01.getEntity(),"utf-8");
        System.out.println(ress);
    }
    @Test(dependsOnMethods={"test01"})
    public void test02() throws IOException {
       String uri=bundle.getString("testpostcookie.url");
       String test02url=this.url+uri;
       HttpPost post=new HttpPost(test02url);
       DefaultHttpClient clien=new DefaultHttpClient();
       clien.setCookieStore(this.store);
       JSONObject paraj=new JSONObject();
       paraj.put("name","dog");
       paraj.put("age","11");
       post.setHeader("content-type","application/json");
       StringEntity entity=new StringEntity(paraj.toString(),"utf-8");
       post.setEntity(entity);
       String results;
       HttpResponse response02=clien.execute(post);
       results= EntityUtils.toString(response02.getEntity(),"utf-8");
        System.out.println(results);
       JSONObject re1=new JSONObject(results);
       String dogg=(String)re1.get("dogg");
       String status=(String)re1.get("status");
        Assert.assertEquals("success",dogg);
        Assert.assertEquals("1",status);
    }
}