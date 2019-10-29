package com.test.httpclient.Cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class myCookies {
    private String url;
    private ResourceBundle bundle;
    private CookieStore store;
    @BeforeTest
    public void test1(){
      bundle=ResourceBundle.getBundle("application", Locale.CHINA   );
      url=bundle.getString("test.url");
  }
    @Test
    public void test2() throws IOException {
      String result;
      String uri=bundle.getString("getCookies.url");
      String testurl=this.url+uri;
      HttpGet get=new HttpGet(testurl);
      //HttpClient client =new DefaultHttpClient();
        DefaultHttpClient client=new DefaultHttpClient();
      HttpResponse response=client.execute(get);
      //result= EntityUtils.toString(response.getEntity(),"utf-8");
      //System.out.println(result);
        this.store=client.getCookieStore();
        List<Cookie> cookielist=store.getCookies();
        for(Cookie cookie:cookielist){
            String name=cookie.getName();
            String value=cookie.getValue();
            System.out.println("name= "+name+": value= "+value);
        }

   }
   @Test(dependsOnMethods = "test2")
   public void test3() throws IOException {
        String urii=bundle.getString("testwithcookie.url");
        String testurll=this.url+urii;
        HttpGet gett=new HttpGet(testurll);
        DefaultHttpClient clientt=new DefaultHttpClient();
        clientt.setCookieStore(this.store);
        HttpResponse responses=clientt.execute(gett);
        //get status code
       int statuscode=responses.getStatusLine().getStatusCode();
       System.out.println("staus code= "+statuscode);
       if(statuscode==200){
           String resu=EntityUtils.toString(responses.getEntity(),"utf-8");
           System.out.println(resu);
       }

   }

}
