package thread;

import org.testng.annotations.Test;

public class MultiThreadOnAnnotation {
    @Test(invocationCount = 3,threadPoolSize = 2)
    public void test(){
        System.out.printf("Thread id :%s%n",Thread.currentThread().getId());
    }
}
