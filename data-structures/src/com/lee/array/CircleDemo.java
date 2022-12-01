package com.lee.circle;

import java.util.Scanner;

/**
 * 环形数组
 * @guofulei24
 */

public class CircleDemo {
    public static void main(String[] args) {
        System.out.print("请输入数组大小：");
        Scanner scanner = new Scanner(System.in);
        int maxSize = scanner.nextInt();
        Circle circle = new Circle(maxSize);
        boolean run = true;
        while (run) {
            System.out.println("a->向数组添加元素");
            System.out.println("g->从数组头部元素");
            System.out.println("s->展示数组");
            char c = scanner.next().charAt(0);
            switch (c) {
                case 'a':
                    System.out.print("请输入数值：");
                    int i = scanner.nextInt();
                    circle.add(i);
                    break;
                case 'g':
                    circle.getFront();
                    break;
                case 's':
                    circle.show();
                    break;
                default:
                    break;
            }
        }
    }
}

class Circle {
    private int maxSize;
    private int front;
    private int end;
    private int arr[];

    public Circle(int maxSize) {
        this.maxSize = maxSize;
        this.front = 0;
        this.end = 0;
        this.arr = new int[maxSize];
    }

    public boolean isEmpty() {
        if (front == end) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {
        if ((end + 1) % maxSize == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void add(int no) {
        if (isFull()) {
            throw new RuntimeException("数组已满");
        }
        arr[end] = no;
        end = (end + 1) % maxSize;
    }

    public void getFront() {
        if (isEmpty()) {
            throw new RuntimeException("数组为空");
        }
        System.out.println("当前头部值：" + arr[front]);
        front = (front + 1) % maxSize;
    }

    public void show() {
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    public int size() {
        return (end + maxSize - front) % maxSize;
    }

}
