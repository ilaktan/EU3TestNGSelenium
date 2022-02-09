package com.cybertek.tests.day7_testNG;

import org.testng.annotations.*;

public class BeforeAfterMethod {

    @BeforeClass
    public void setupClass(){
        System.out.println("--before class--");
        System.out.println("execute one time before the class");
    }

    @Test
    public void test1(){
        System.out.println("First Test Case");
    }
    @Ignore
    @Test
    public void test2(){
        System.out.println(" Second Test Case");

    }
    @Test
    public void test3(){
        System.out.println(" Third Test Case");

    }
    @BeforeMethod
    public void setup(){
        System.out.println("Before class");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("after class");




                    }
                    @AfterClass
                    public  void tearDownClass(){
                        System.out.println("--After class");
                        System.out.println("some repording");
                    }

}
