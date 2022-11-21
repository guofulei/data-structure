package com.lee.stack;

import java.util.Scanner;

/**
 * 使用数组模拟栈
 * @guofulei24
 */
public class StackDemo {
    public static void main(String[] args) {
        StackArray stackArray = new StackArray(6);
        Scanner scanner = new Scanner(System.in);
        boolean enabled=true;
        String key="";
        while (enabled){
            System.out.println("push:向栈中添加元素");
            System.out.println("pop:出栈");
            System.out.println("show:展示栈");
            System.out.println("exit:退出");
            System.out.print("请输入选择:");
            key=scanner.next();
            switch (key){
                case "push":
                    System.out.print("请输入数值:");
                    int i = scanner.nextInt();
                    stackArray.pushStack(i);
                    break;
                case "pop":
                    int i1 = stackArray.popStack();
                    System.out.println("出栈数："+i1);
                    break;
                case "show":
                    stackArray.showStack();
                    break;
                case "exit":
                    enabled=false;
                    System.out.println("退出");
                    break;
                default:
                    break;
            }
        }
    }
}
class StackArray{
    public int maxSize;
    public int[] stack;
    public int top=-1;

    public StackArray(int size) {
        this.maxSize = size;
        stack=new int[maxSize];
    }
    public boolean isFull(){
        return top==maxSize-1;
    }

    public boolean isEmpty(){
        return top==-1;
    }
    public void pushStack(int no){
        if (isFull()){
            throw new RuntimeException("栈已满");
        }
        top++;
        stack[top]=no;
    }
    public int popStack(){
        if(isEmpty()){
            throw new RuntimeException("栈空");
        }
        int value=stack[top];
        top--;
        return value;
    }
    public void showStack(){
        if(isEmpty()){
            throw new RuntimeException("栈空");
        }
        for (int i=top;i>=0;i--){
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }
}
