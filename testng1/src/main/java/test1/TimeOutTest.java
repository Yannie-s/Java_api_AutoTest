package test1;

import org.testng.annotations.Test;

public class TimeOutTest {
    @Test(timeOut = 2000)
    public void test1() throws InterruptedException {
        Thread.sleep(3000);
    }
    @Test(timeOut = 3000)
    public void test2() throws InterruptedException {
        Thread.sleep(2000);
    }
}
