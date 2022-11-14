package com.lee.array;

/**
 * 合并两个有序数组
 * guofulei24
 */
public class OrderArrayDemo {
    public static void main(String[] args) {
        int[] a=new int[6];
        a[0]=1;
        a[1]=3;
        a[2]=5;
        a[3]=7;
        a[4]=9;
        a[5]=11;
        int[] b=new int[6];
        b[0]=2;
        b[1]=4;
        b[2]=6;
        b[3]=8;
        b[4]=10;
        b[5]=12;
        orderArray(a,b);
    }

    private static void orderArray(int[] int1, int[] int2){
        int[] newArr=new int[int1.length+int1.length];
        int i=0;
        int j=0;
        int h=0;
        while (i<int1.length && j<int2.length){
            if (int1[i]<=int2[j]){
                newArr[h++]=int1[i++];
            }else {
                newArr[h++]=int2[j++];
            }
        }
        for (;i<int1.length;){
            newArr[h++]=int1[i++];
        }
        for (;j<int2.length;){
            newArr[h++]=int2[j++];
        }
        int l=0;
        while (l<newArr.length){
            System.out.printf("arr[%d]=%d\n",l,newArr[l]);
            l++;
        }

    }
}
