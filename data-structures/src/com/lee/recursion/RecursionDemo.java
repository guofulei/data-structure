package com.lee.recursion;

/**
 * 递归回溯
 * @guofulei24
 */
public class RecursionDemo {
    public static void main(String[] args) {
        int[][] arr = new int[7][8];
        //递归
        for (int i = 0; i < arr[0].length; i++) {
            arr[0][i] = 1;
            arr[arr.length - 1][i] = 1;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = 1;
            arr[i][arr[i].length - 1] = 1;
        }
        arr[3][1] = 1;
        arr[3][2] = 1;
        int count=0;
        nextIsTrue(arr,1,1,count);
        for (int[] a : arr) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }

    public static boolean nextIsTrue(int[][] arr, int i, int j,int count) {
        if (arr[5][6] == 2) {
            return true;
        } else {
            if (arr[i][j] == 0) {
                arr[i][j] = 2;
                //下 右 上 左
                if (nextIsTrue(arr,i+1,j,count)) {
                    count++;
                    return true;
                } else if (nextIsTrue(arr,i,j+1,count)) {
                    count++;
                    return  true;
                } else if (nextIsTrue(arr,i-1,j,count)) {
                    count++;
                    return true;
                }else if(nextIsTrue(arr,i,j-1,count)){
                    count++;
                    return true;
                }else {
                    arr[i][j]=3;
                    count--;
                    return false;
                }
            } else {
                return false;
            }

        }
    }
}
