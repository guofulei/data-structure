package com.lee.array;

/**
 * 稀疏数组
 *
 * @guofulei24
 */
public class SparseArrayDemo {
    public static void main(String[] args) {
        int[][] arrays = new int[11][11];
        arrays[1][2] = 1;
        arrays[2][3] = 2;
        arrays[3][4] = 3;

        //遍历二维数组并统计有效个数
        int number = 0;
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays.length; j++) {
                if (arrays[i][j] != 0) {
                    number++;
                }
                System.out.printf("%d\t", arrays[i][j]);
            }
            System.out.println();
        }

        //二维数组转稀疏数组
        int[][] sparsearray = new int[number+1][3];
        sparsearray[0][0] = arrays.length;
        sparsearray[0][1] = arrays.length;
        sparsearray[0][2] = number;
        int index=1;
        for (int i = 0; i < arrays.length; i++) {
            for (int j = 0; j < arrays.length; j++) {
                if(arrays[i][j]!=0){
                    sparsearray[index][0]=i;
                    sparsearray[index][1]=j;
                    sparsearray[index][2]=arrays[i][j];
                    index++;
                }
            }
        }

        //遍历稀疏数组
        for (int i=0;i<sparsearray.length;i++){
            for (int j=0;j<3;j++){
                System.out.printf("%d\t", sparsearray[i][j]);
            }
            System.out.println();
        }
        //稀疏数组转二维数组
        int[][] arr=new int[sparsearray[0][0]][sparsearray[0][1]];
        for (int i=1;i<sparsearray.length;i++){
             arr[sparsearray[i][0]][sparsearray[i][1]]=sparsearray[i][2];
        }
        //遍历二维数组
        for (int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.printf("%d\t",arr[i][j]);
            }
            System.out.println();
        }
    }
}

