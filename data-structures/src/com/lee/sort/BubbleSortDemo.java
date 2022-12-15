package com.lee.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * @guofulei24
 */
public class BubbleSortDemo {
    public static void main(String[] args) {
        int[] arr={10,6,12,2,3};
        int temp=0;
        Boolean state=false;
        for (int i=0;i<arr.length-1;i++){
            for (int j=0;j<arr.length-i-1;j++){
                if (arr[j]>arr[j+1]){
                    state=true;
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            System.out.println("第"+i+1+"次排序");
            System.out.println(Arrays.toString(arr));
            if(!state){
                break;
            }else {
                state=false;
            }
        }
    }
}
