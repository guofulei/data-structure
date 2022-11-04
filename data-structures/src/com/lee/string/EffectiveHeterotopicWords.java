package com.lee.string;

/**
 * 有效的字母异位词
 * @guofulei24
 */
public class EffectiveHeterotopicWords {
    public static void main(String[] args) {
        System.out.println(isEffectiveHeterotopic("abcder","abcder"));
    }
    public static boolean isEffectiveHeterotopic(String a, String b){
        if(a.length()!=b.length()){
            return false;
        }else {
            int[] c=new int[26];
            for (int i=0;i<a.length();i++){
                //a 97 =a  从0开始
                c[a.charAt(i)-'a']++;
            }
            for(int i=0;i<b.length();i++){
                c[a.charAt(i)-'a']--;
            }
            for (int i:c){
                if(i!=0){
                    return false;
                }
            }
            return true;
        }

    }
}
