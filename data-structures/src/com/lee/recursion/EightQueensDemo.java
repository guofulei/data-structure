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

    public static void check(int n) {
        if (n == max) {
            showQueens();
            return;
        }
        for (int i = 0; i < queens.length; i++) {
            queens[n] = i;
            if (isConflict(n)) {
                check(n + 1);
            }
        }

    }

    public static boolean isConflict(int n) {
        for (int i = 0; i < n; i++) {
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
