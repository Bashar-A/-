package com.company;

import java.util.ArrayList;

public class Sort {
    public static void QuickSort(ArrayList<Integer> array, int a, int b){
        if( a >= b )return;
        int pivot = array.get(b);
        int index = a;
        for(int i = a ; i <b; i++){
            if(array.get(i) < pivot){
                int temp = array.get(i);
                array.set(i, array.get(index));
                array.set(index, temp);
                index++;
            }
        }
        int temp = array.get(b);
        array.set(b, array.get(index));
        array.set(index, temp);

        QuickSort(array,a,index - 1);
        QuickSort(array,index + 1, b);


    }
}
