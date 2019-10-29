package test1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ParameterMethod {
    @Test(dataProvider = "data")
    public void test1(String name,int age){
        System.out.println("test1 name= "+name+"; age= "+age);
    }
    @DataProvider(name="data")
    public Object[][] datapro(){
        Object[][] obje=new Object[][]{
                {"zhangsan",10},
                {"lisi",20},
                {"wanger",30}
        };
        return obje;
    }
    @Test(dataProvider = "meth")
    public void test2(String name,int age){
        System.out.println("test2 name= "+name+"; age= "+age);
    }
    @Test(dataProvider = "meth")
    public void test3(String name,int age){
        System.out.println("test3 name= "+name+"; age= "+age);
    }
    @DataProvider(name="meth")
    public Object[][] methtest(Method method){
        Object[][] obo=null;
        if(method.getName().equals("test2")){
            obo=new Object[][]{
                {"zhangsansan",12 },
                    {"lisisi",11}
        };
    }else if(method.getName().equals("test3")){
            obo=new Object[][]{
                    {"wangwer",30},
                    {"zhaoliuliu",40}};
        }
        return obo;
        }
}
