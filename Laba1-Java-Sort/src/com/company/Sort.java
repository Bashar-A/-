package com.company;

public class Sort {
    public static void QuickSort(int array[], int a, int b){
        if( a >= b )return;
        int pivot = array[b];
        int index = a;
        for(int i = a ; i <b; i++){
            if(array[i] < pivot){
                int temp = array[i];
                array[i] = array[index];
                array[index] = temp;
                index++;
            }
        }
        int temp = array[b];
        array[b] = array[index];
        array[index] = temp;

        QuickSort(array,a,index - 1);
        QuickSort(array,index + 1, b);
    }
    public static void SelectionSort(int array[], int n) {
        for (int i = 0; i < n - 1 ; i++){
            int min = array[i];
            int index = i;
            for(int j = i; j < n ; j++){
                if(min > array[j]) {
                    min = array[j];
                    index = j;
                }
            }
            if(index != i){
                int temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }

        }
    }
}
