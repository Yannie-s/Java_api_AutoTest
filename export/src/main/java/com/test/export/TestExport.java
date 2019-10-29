package com.test.export;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestExport {
    @Test
    public void test1(){
        Assert.assertEquals(1,1);
    }
    @Test
    public void test2(){
        Assert.assertEquals(2,1);
    }
    @Test
    public void test3(){
        Assert.assertEquals("test3","testtest");
    }
    @Test
    public void logtest(){
        Reporter.log("this is my first log ");
        throw new RuntimeException("this is me throw exception");
    }
}
