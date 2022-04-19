package com.sda;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {



        ArrayList<Integer> arrayList=new ArrayList<>();
        Random rand = new Random();

        for (int j = 0; j<10; j++)
        {
            int pick = rand.nextInt(100);
            if(pick==0)
                pick=1;
            arrayList.add(pick);
        }
        for (int j = 0; j<10; j++){
            System.out.println("runda "+j);
            Allfunction(arrayList.get(j), arrayList.get(9-j));
        }


    }

    public static void Allfunction(int number1,int number2){

        SumInt(number1,number2);
        MultiplyInt(number1,number2);
        DivideInt(number1,number2);
        SubtractInt(number1,number2);

    }


    public static void SumInt(int number1,int number2){

        int sum=number1+number2;
        System.out.println(sum);

    }
    public static void MultiplyInt(int number1,int number2){

        int multiply=number1*number2;
        System.out.println(multiply);

    }
    public static void DivideInt(int number1,int number2){

        int divide=number1/number2;
        System.out.println(divide);

    }
    public static void SubtractInt(int number1,int number2){

        int subtract=number1-number2;
        System.out.println((subtract));

    }





}
