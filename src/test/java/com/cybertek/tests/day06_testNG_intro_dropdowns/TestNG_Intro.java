package com.cybertek.tests.day06_testNG_intro_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Intro {

    @AfterClass
    public void teardownClass(){
        System.out.println("---> afterClass is running...");
    }


    @BeforeClass
    public void setupClass(){
        System.out.println("---> beforeClass is running...");
    }

    @BeforeMethod//support for Tests. Don't have run button
    public void setupMethod(){
        System.out.println("---> beforeMethod is running...");
    }

    @AfterMethod
    public void tearDownMethod(){
        System.out.println("---> afterMethod is running...");
    }


   @Test
    public void test1(){
       System.out.println("Running test1...");
       String actual = "apple";
       String expected = "apples";
       Assert.assertEquals(expected, actual);
      // Assert.assertFalse(false);

    }

    @Test
    public void test2(){
        System.out.println("Running Test2 ....");
        String actual = "apple";
        String expected = "apples";
        Assert.assertEquals(actual,expected);


    }

}

