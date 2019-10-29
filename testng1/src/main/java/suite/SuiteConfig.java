package suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SuiteConfig {
    @BeforeSuite
    public void befores(){
        System.out.println("beforesuite methond");
    }
    @AfterSuite
    public void afters(){
        System.out.println("aftersuite method");
    }
    @BeforeTest
    public void btest(){
        System.out.println("before test");
    }
    @AfterTest
    public void atest(){
        System.out.println("after test");
    }
}
