package com.lee.string;

/***
 * 双指针反转字符串
 */
public class DoublePointerReversalStr {
    public static void main(String[] args) {
        String s="qweasdzxc";
        char[] chars = s.toCharArray();
        char[] chars1 = reversalStr(chars);
        String str="";
        for (char c : chars1) {
             str=str+c;
        }
        System.out.println("反转后："+str);
    }

    private static char[] reversalStr(char[] chars){
        int last=chars.length-1;
        int start=0;
        char temp;
        while (last!=start){
            temp=chars[last];
            chars[last]=chars[start];
            chars[start]=temp;
            start++;
            last--;
        }
        return chars;
    }

}
