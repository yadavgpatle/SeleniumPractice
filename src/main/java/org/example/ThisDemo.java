package org.example;

public class ThisDemo {

    int a = 4;

    void getData(){
        int a = 9;
        System.out.println(this.a);
    }

    public static void main(String [] args){
        ThisDemo thisDemo = new ThisDemo();
        thisDemo.getData();
    }
}
