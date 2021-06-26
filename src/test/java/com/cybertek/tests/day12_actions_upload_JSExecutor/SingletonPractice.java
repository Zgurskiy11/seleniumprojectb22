package com.cybertek.tests.day12_actions_upload_JSExecutor;

import org.testng.annotations.Test;

public class SingletonPractice {

    @Test (priority = 1)
    public void understandingSingleton1(){
        String str1 = Singleton.getWord();
        System.out.println("str1 = " + str1);

        String str2 = Singleton.getWord();// its not null already
        System.out.println("str2 = " + str2);

        String str3 = Singleton.getWord();
        System.out.println("str3 = " + str3);
        System.out.println("=========");

        Singleton.setWord("kjhk");

        System.out.println("//////////////////////");
    }

    @Test (priority  =2)
    public void singletonTest2(){
        String str4 = Singleton.getWord();
        System.out.println("str4 = " + str4);
    }







}
