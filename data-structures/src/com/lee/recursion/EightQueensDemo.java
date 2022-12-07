package com.lee.recursion;

import javax.management.MXBean;

/**
 * 八皇后问题
 *
 * @guofulei
 */
public class EightQueensDemo {
    private static final int max = 8;
    private static int[] queens = new int[max];

    public static void main(String[] args) {
        check(0);
    }
    
    //放入第n个皇后
    public static void check(int n) {
        if (n == max) {
            showQueens();
            return;
        }
        for (int i = 0; i < queens.length; i++) {
            queens[n] = i;
            //第n个皇后和之前的皇后位置是否有冲突
            if (isConflict(n)) {
                //如果没有冲突 放入第n+1给皇后 （递归）
                check(n + 1);
            }
        }

    }
    
    //第n个皇后位置与之前的皇后位置有冲突
    public static boolean isConflict(int n) {
        for (int i = 0; i < n; i++) {
            /**
            *  如果n等于2 会遍历两次 会拿 n皇后和n之前的皇后比较是否在一列
            *  queens[0]==queens[2]
            *  queens[1]==queens[2] 
            * 
            * 如果 Math.abs(n-i)==Math.abs(queens[n]-queens[i])
            * 说明皇后i和皇后n在同一斜线
            * i每次都在换行 不用担心在同一行中
            */
            if (queens[i] == queens[n] || Math.abs(n - i) == Math.abs(queens[n] - queens[i])) {
                return false;
            }
        }
        return true;
    }

    //展示数组
    public static void showQueens() {
        for (int i = 0; i < queens.length; i++) {
            System.out.printf("%d" + " ", queens[i]);
        }
        System.out.println();
    }

}
