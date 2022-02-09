package com.cybertek.tests.day12_properties_driver_test;

public class Singleton {
    //singleton class will have private constructor
    //it means other classes connot create object of this class

    private Singleton(){}
    private static String str;
    public static  String getInstance(){

        //if str had no value, initialize it and return it

        if(str==null){
            System.out.println("str is null.asssigning value it");
            str="somevalue";

        }else{
            //if it has value just return it
            System.out.println("it has value,just returning it");
        }
        return str;
    }

}
