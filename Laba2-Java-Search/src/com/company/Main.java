package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        String  input;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter n: ");
        input = br.readLine();
        int n = Integer.parseInt(input);

        ArrayList <Integer> array = new ArrayList<>();

        Generate(array,n);
        Sort.QuickSort(array,0,n-1);
        if(n <= 1000)OutPut(array,n);

        System.out.println("Enter the element you are looking for (-1 for exit): ");
        input = br.readLine();
        int s = Integer.parseInt(input);
        while(s != -1){
            try {

                long start = System.currentTimeMillis();
                int index = Search.BinarySearch(array,0,n-1,s);
                long end = System.currentTimeMillis();
                long elapsedTime = end - start;
                System.out.println("BinarySearch time: " + elapsedTime);

                start = System.currentTimeMillis();
                array.contains(s);
                end = System.currentTimeMillis();
                elapsedTime = end - start;
                System.out.println("Default search time: " + elapsedTime);

                System.out.println("s = array[i], where i =  " + index);



            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Enter the element you are looking for (-1 for exit): ");
            input = br.readLine();
            s = Integer.parseInt(input);
        }

    }


    public static void OutPut(ArrayList<Integer> array, int n)  {
        for (int i = 0; i < n; i++){
            System.out.print(array.get(i) + " ");
        }
        System.out.println();
    }
    public static void Generate(ArrayList<Integer> array, int n)  {
        Random random = new Random();
        for (int i = 0; i < n; i++){
            array.add(random.nextInt(1000000));
        }
    }

}
