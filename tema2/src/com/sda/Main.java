package com.sda;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        int[] arrayofints= {1,53,2,5,8,9,331, 0};
        int[] arrayofints2= {1,2,2,2,4,5,8,2,9,0};
        System.out.println(maxNumber(arrayofints));
        System.out.println(minNumber(arrayofints));
        int[] sumwith2=sumTwo(arrayofints2);
        for (int elemet:sumwith2){
            System.out.print(elemet + " ");
        }
        System.out.println();
        int[] arrayofints3= {1,2,2,4,1,1,1,2,5,1,0};
        int[] binary=onesAndZeroes(arrayofints3);

        for (int elemet:binary){
            System.out.print(elemet + " ");
        }
        int[] howmanyletters= {1,2,3,2,2,4,1};
        System.out.println();
        System.out.println(letterOccurrence(howmanyletters,2));
    }
    public static int maxNumber(int[] array){
        int max=array[0];
        for(int number:array){
            if(number>max)
                max=number;
        }
        return max;
    }
    public static int minNumber(int[] array){
        int min=array[0];
        for(int number:array){
            if(number<min)
                min=number;
        }
        return min;
    }
    public static int[] sumTwo(int[] array){
        int X=2;
        for (int i=0;i<array.length;i++){
            array[i]=array[i]+2;
        }
        return array;
    }
    public static int[] onesAndZeroes(int[] array){
        for (int i=0;i<array.length ;i++){
            if (array[i]!=1)
                array[i]=0;
        }
        return array;
    }

    public static int letterOccurrence(int[] array, int X){
        int counter=0;
        for (int element:array){
            if(element==X)
                counter++;
        }
        return counter;
    }
}
