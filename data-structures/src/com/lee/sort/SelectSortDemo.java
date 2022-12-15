package com.lee.sort;

import java.util.Arrays;

/**
 * 选择排序
 * @guofulei24
 */
public class SelectSortDemo {
    public static void main(String[] args) {
        int[] arr = {19, 23, 11, 35, 9};

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int minIndex = i;
                int min = arr[minIndex];
                if (arr[i] > arr[j]) {
                    minIndex = j;
                    min = arr[minIndex];
                }
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            System.out.println("第"+i+1+"次排序");
            System.out.println(Arrays.toString(arr));
        }
    }
}
