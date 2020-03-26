package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        System.out.println("Enter n: ");
        input = br.readLine();
        int n = Integer.parseInt(input);
        System.out.println("Enter m: ");
        input = br.readLine();
        int m = Integer.parseInt(input);

        int[][] array1 = new int[n][m];
        int[][] array2 = new int[n][m];
        int[][] array3 = new int[n][m];
        Random random = new Random();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                array1[i][j] = random.nextInt(10000);
                array2[i][j] = array1[i][j];
                array3[i][j] = array1[i][j];
            }
        }

        //SelectionSort
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++){
            Sort.SelectionSort(array1[i], m);
        }
        long end = System.currentTimeMillis();
        long elapsedTime = end - start;
        System.out.println("SelectionSort time: " + elapsedTime + " ms");


        //QuickSort
        start = System.currentTimeMillis();
        for (int i = 0; i < n; i++){
            Sort.QuickSort(array2[i],0,m-1);
        }
        end = System.currentTimeMillis();
        elapsedTime = end - start;
        System.out.println("QuickSort time: " + elapsedTime+ " ms");

        //DefaultSort
        start = System.currentTimeMillis();
        for (int i = 0; i < n; i++){
            Arrays.sort(array3[i]);
        }
        end = System.currentTimeMillis();
        elapsedTime = end - start;
        System.out.println("Default sort time: " + elapsedTime+ " ms");

    }
}
