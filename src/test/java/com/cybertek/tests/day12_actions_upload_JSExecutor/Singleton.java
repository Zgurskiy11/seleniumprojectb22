package com.cybertek.tests.day12_actions_upload_JSExecutor;
/*
    We will create similar logic we created in Driver utility class. But it will be for a String
     */
public class Singleton {
    //create private constructor
    private Singleton(){}

    //by making String private, we will insure that we create access only thru getter setter
    private static String word;//static, so we can use in static methods

    //create static setter getter
    public static String getWord() { // we allow user to access to 'word' in the way that we want them to have
        if (word==null){
            System.out.println("First time call. Word object is null. Assigning value to it now");
            word = "something";
        }else{
            System.out.println("word already has a value");
        }
        return word;
    }

    public static void setWord(String word) {
        Singleton.word = word;
    }
}
