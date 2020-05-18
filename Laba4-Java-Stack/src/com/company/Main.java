package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("D:\\Projects\\SiAOD\\Laba4-Java-Stack\\test.txt");
        List<String> contents = Files.readAllLines(path);

        int maxSize = contents.size();
        Deque deque1 = new Deque(maxSize);
        Deque deque2 = new Deque(maxSize);

        System.out.println("До сортировки:");
        for (int i = 0; i < contents.size(); i++) {
            deque1.addElementTop(contents.get(i));
            System.out.println(contents.get(i));
        }

        while (!deque1.isEmpty()){
            if(deque2.isEmpty()){
                deque2.addElementTop(deque1.getTop());
                deque1.deleteElementTop();
            }
            if(deque1.getTop().compareTo(deque2.getTop()) < 0){
                deque2.addElementTop(deque1.getTop());
                deque1.deleteElementTop();
            }
            else if(deque1.getTop().compareTo(deque2.getBot()) > 0){
                deque2.addElementBot(deque1.getTop());
                deque1.deleteElementTop();
            }
            else {
                deque1.addElementBot(deque2.getBot());
                deque2.deleteElementBot();
            }
        }


        System.out.println();
        System.out.println("После сортировки:");
        while (!deque2.isEmpty()){
            System.out.println(deque2.deleteElementTop());
        }
    }
}
