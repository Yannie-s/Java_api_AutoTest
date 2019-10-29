package test1;

import org.testng.annotations.*;

public class BasicAnnotation {
    @Test
    public void test1(){
        System.out.println("this is my first method at home");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforemethod");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod");
    }
    @Test
    public void test2(){
        System.out.println("test2");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeclass");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("afterclass");
    }
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("Aftersuite");
    }

}

