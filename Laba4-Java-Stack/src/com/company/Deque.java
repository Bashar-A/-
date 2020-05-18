package com.company;

public class Deque{
    private int dequeSize;
    private String[] dequeArray;
    private int top;
    private int bot;

    public Deque(int n){
        this.dequeSize = n;
        this.dequeArray = new String[dequeSize];
        this.top = -1;
        this.bot = 0;
    }

    public void addElementTop(String element){
        dequeArray[++top] = element;
    }

    public void addElementBot(String element){
        for (int i = top+1; i > 0; i--) {
            dequeArray[i] = dequeArray[i - 1];
        }
        dequeArray[bot] = element;
        top++;
    }

    public String deleteElementTop(){
        return dequeArray[top--];
    }

    public String deleteElementBot(){
        String temp = dequeArray[0];
        for (int i = 0; i < top; i++) {
            dequeArray[i] = dequeArray[i + 1];
        }
        top--;
        return temp;
    }

    public String getTop(){
        return dequeArray[top];
    }

    public String getBot(){
        return dequeArray[bot];
    }

    public boolean isEmpty(){
        return (top + 1 == bot);
    }

    public boolean isFull(){
        return (top == dequeSize - 1);
    }

}