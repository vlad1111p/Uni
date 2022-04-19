package com.vlad;

public class Main {

    public static void main(String[] args) {
        int[] q1 = {21, 3, 5, 18, 7};


        int[] q2 = {10, 9, 7, 4, 3};

        int[] q3 = new int[q1.length + q2.length];
        int[] q4 = new int[q1.length + q2.length];
        int[] q5 = new int[q1.length + q2.length];
        merge(q1, q2, q3);
        q4=bubbleAscendingOrder(q3);
        q5=bubbleDescendingOrder(q3);


    }

    public static int[] merge(int[] q1, int[] q2, int[] q3) {
        for (int i = 0; i < q2.length + q1.length; i++) {
            if (i < q1.length) {
                q3[i] = q1[i];
            } else {
                q3[i] = q2[i - q1.length];
            }
        }
        for (int e : q3) {
            System.out.print(e + " ");
        }
        System.out.println();
        return q3;
    }

    public static int[] bubbleAscendingOrder(int[] q3) {
        boolean sorting = true;
        while (sorting) {
            sorting = false;
            for (int i = 0; i < q3.length - 1; i++) {
                if (q3[i] > q3[i + 1]) {
                    int temp = q3[i];
                    q3[i] = q3[i + 1];
                    q3[i + 1] = temp;
                    sorting = true;
                }
            }
        }

        for (int e : q3) {
            System.out.print(e + " ");

        }
        System.out.println();
        return q3;

    }
    public static int[] bubbleDescendingOrder(int[] q3) {
        boolean sorting = true;
        while (sorting) {
            sorting = false;
            for (int i = 0; i < q3.length - 1; i++) {
                if (q3[i] < q3[i + 1]) {
                    int temp = q3[i];
                    q3[i] = q3[i + 1];
                    q3[i + 1] = temp;
                    sorting = true;
                }
            }
        }

        for (int e : q3) {
            System.out.print(e + " ");
        }
        System.out.println();
        return q3;

    }
}

