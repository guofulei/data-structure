package com.lee.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * @guofulei24
 */
public class ShellSortDemo {
    public static void main(String[] args) {
        int[] arr = {19, 3, 2, 5, 6, 34, 43, 23};
        shell01(arr);
        shell02(arr);
    }

    public static void shell01(int[] arr) {
        int count = 0;
        boolean isTrue = false;
        for (int steps = arr.length / 2; steps > 0; steps /= 2) {
            count++;
            for (int i = steps; i < arr.length; i++) {
                for (int j = i - steps; j >= 0; j -= steps) {
                    if (arr[j] > arr[j + steps]) {
                        isTrue = true;
                        int temp = arr[j + steps];
                        arr[j + steps] = arr[j];
                        arr[j] = temp;
                    }
                    if (!isTrue) {
                        break;
                    } else {
                        isTrue = false;
                    }
                }
            }
            System.out.println("第" + count + "次排序" + Arrays.toString(arr));
        }
    }

    public static void shell02(int[] arr) {
        int count = 0;
        for (int steps = arr.length / 2; steps > 0; steps /= 2) {
            for (int i = steps; i < arr.length; i++) {
                int insertIndex = i;
                int insertValue = arr[i];
                if (arr[i] < arr[i - steps]) {
                    while (insertIndex - steps >= 0 && insertValue < arr[insertIndex - steps]) {
                        arr[insertIndex] = arr[insertIndex - steps];
                        insertIndex -= steps;
                    }
                    arr[insertIndex] = insertValue;
                }

            }
            System.out.println("第" + (count++) + "次排序" + Arrays.toString(arr));
        }
    }
}
