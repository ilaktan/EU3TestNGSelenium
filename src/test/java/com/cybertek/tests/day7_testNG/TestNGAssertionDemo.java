package com.cybertek.tests.day7_testNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAssertionDemo {

    @BeforeMethod
    public void setup(){
        System.out.println("Open browser");

    }

    @Test
    public void test1(){



        System.out.println("first assertion");
        Assert.assertEquals("title","title");


        System.out.println("second assertion");

        Assert.assertEquals("url","url");


    }
    @Test
    public void test2(){
        Assert.assertEquals("abc","abc");
    }
    @Test
    public void test3(){

        String expectedTitle="Cyb";
        String actualTitle="Cybertek";

        Assert.assertTrue(actualTitle.startsWith(expectedTitle),"Verify title statrts with Cyb");
    }
    @Test
    public void test4(){
        //verify email contains @sign
        String email="mikesmith";
        Assert.assertTrue(email.contains("@"),"verify email");
    }
    @Test
    public void test5(){
        
        Assert.assertFalse(0>1,"verify that ) is not grater than 1");
    }

   @Test
   public void test6()        {

        Assert.assertNotEquals("one","two");
   }
    @AfterMethod
    public void tearDown(){

        System.out.println("Close browser");
    }
}
