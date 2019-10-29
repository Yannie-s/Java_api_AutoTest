package test1;

import org.testng.annotations.Test;

public class ExpectedException {
    @Test(expectedExceptions = RuntimeException.class)
    public void runSuccessException(){
        System.out.println("run success exception");
        throw new RuntimeException();
    }
    @Test(expectedExceptions = RuntimeException.class)
    public void runFailException(){
        System.out.println("run fail exception");
    }
}
