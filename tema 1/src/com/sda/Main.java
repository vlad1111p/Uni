package com.sda;

public class Main {





    public static void main(String[] args) {
    init(22,2);
    String word="SDA";
    System.out.println("the length of the word is:" + lengthOfString(word));
    firstAndLast("telefon");

    }
    public static void init(int param1,int param2){
        intSum(param1,param2);
        intMultiply(param1,param2);
        intDivide(param1,param2);
        intSubtract(param1, param2);

    }

    public static void intSum(int param1,int param2){
        int param3=param1+param2;
        System.out.println("the sum of these numbers is: " +param3);
    }
    public static void intMultiply(int param1,int param2){
        int param3=param1*param2;
        System.out.println("the result of the multiplication is: " +param3);
    }
    public static void intDivide(int param1,int param2){
        int param3=param1/param2;
        System.out.println("the result of the division is: " +param3);
    }
    public static void intSubtract(int param1,int param2){
        int param3=param1-param2;
        System.out.println("the result of the subtraction is: " +param3);
    }
    public static int lengthOfString(String word){
        return word.length();
    }
    public static void firstAndLast(String word){
        System.out.println( String.valueOf(word.charAt(0)).concat(String.valueOf(word.charAt(word.length()-1))));
    }
}
