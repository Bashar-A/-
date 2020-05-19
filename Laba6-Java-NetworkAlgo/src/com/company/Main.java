package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Floyd floyd = new Floyd(800,"D:\\Projects\\SiAOD\\Laba6-Java-NetworkAlgo\\test2.txt");
        System.out.println("Время поиска = " + floyd.getElapsedTime());
        System.out.println("Длина кратчайшего раастояния из (1) в (6)  = " + floyd.getMinPath());
    }




}
