package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        String input, string, string2, substring;
        int n = 0;
        long start, end, elapsedTime1, elapsedTime2;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите строку:");
        string= br.readLine();
        do{
            System.out.println("Введите n: \n" + "1.ввести другю строку\n" + "2.дополнить строку\n" + "3.поиск подстроки\n" + "4.выход\n");
            input= br.readLine();
            n = Integer.parseInt(input);
            switch (n){
                case 1:
                    System.out.println("Введите строку:");
                    string= br.readLine();
                    break;
                case 2:
                    System.out.println("Введите строку:");
                    input= br.readLine();
                    string += input;
                    System.out.println("Новая полученная строка:\n" + string);
                    break;
                case 3:
                    System.out.println("Введите подстроку:");
                    substring= br.readLine();
                    System.out.println("Чувствительность к регистору? (0 - нет, 1- да)");
                    input = br.readLine();
                    string2 = string;

                    if(input.equals("0")){
                        string2 = string.toLowerCase();
                        substring = substring.toLowerCase();
                    }

                    start = System.currentTimeMillis();
                    int index = SubstringSearch.Boyer(string2,substring);
                    end = System.currentTimeMillis();
                    elapsedTime1 = end - start;

                    start = System.currentTimeMillis();
                    index = string2.indexOf(substring);
                    end = System.currentTimeMillis();
                    elapsedTime2 = end - start;


                    if(index != -1){
                        System.out.println("Подстрока была найдена под индексом: "+ index);
                    }
                    else {
                        System.out.println("Подстрока не была найдена!");
                    }
                    System.out.println("Время выполнения упрощенного алгоритма Бойера-Мура = " + elapsedTime1+
                            "\nВремя выполнения стандартного алгоритма поиска подстроки = " + elapsedTime2);
                    break;
                default:
                    break;
            }
        }while(n != 4);

    }
}
