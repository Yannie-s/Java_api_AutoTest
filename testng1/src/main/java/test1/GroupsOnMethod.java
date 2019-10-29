package test1;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {
    @Test(groups="server")
    public void group1(){
        System.out.println("group on 1111");
    }
    @Test(groups="server")
    public void group2(){
        System.out.println("group on 22222");
    }
    @Test(groups="client")
    public void group3(){
        System.out.println("group on 33333");
    }
    @BeforeGroups("server")
    public void bgroupserver(){
        System.out.println("before group server");
    }
    @AfterGroups("server")
    public void agroupserver(){
        System.out.println("after group server");
    }
    @BeforeGroups("client")
    public void bgroupclient(){
        System.out.println("before group client");
    }
    @AfterGroups("client")
    public void agroupclient(){
        System.out.println("after group client");
    }
}
