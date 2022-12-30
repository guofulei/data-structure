package com.lee.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @guofulei24
 */
public class InsertSortDemo {
    public static void main(String[] args) {
        int[] arr = {12, 3, 5, 7, 9, 2, 1};
        int count=0;
        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int insertIndex = i;
            if(arr[i]<arr[i-1]){
                while (insertIndex > 0 && insertValue < arr[insertIndex - 1]) {
                    arr[insertIndex] = arr[insertIndex - 1];
                    insertIndex--;
                }
            }
            count++;
            arr[insertIndex]=insertValue;
            System.out.println("第"+count+"次排序"+ Arrays.toString(arr));
        }
    }
}
