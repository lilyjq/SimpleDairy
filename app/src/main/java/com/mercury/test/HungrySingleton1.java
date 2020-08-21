package com.mercury.test;

public class HungrySingleton1 {
       public static  final HungrySingleton1 instance ;

       static  {
           instance = new HungrySingleton1();
       }

       private HungrySingleton1(){

       }

       public void caculate(){

       }

}
