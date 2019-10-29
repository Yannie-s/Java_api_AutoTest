package test1;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
    @Test
    @Parameters({"name","age"})
    public void test1(String name,int age){
        System.out.println("test1： name= "+name+"; age=: "+age);
    }
}
