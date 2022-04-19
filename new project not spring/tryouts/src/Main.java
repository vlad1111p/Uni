import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {


        int[] arrayOfInts = {22,23,45,56,213,1245,32};

        for(int i=0; i<arrayOfInts.length; i++){
            arrayOfInts[i]+=i;
        }
        int[] arrayOfInts1=new int[7];
        int i=0;

//        for(int number: arrayOfInts){
//            System.out.println(number);
//            arrayOfInts1[i]=number+number;
//
//
//            System.out.println(arrayOfInts1[i]);
//            i++;  System.out.println("  x ");
//        }

        for(int number: arrayOfInts){
            returnMultipliedBy2(number);
        }
    }

    public static void returnMultipliedBy2(int number){


        System.out.println(number*20);

    }



}
