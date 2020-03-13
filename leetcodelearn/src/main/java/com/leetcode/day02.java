package com.leetcode;

public class day02 {
    /**
     * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
     * <p>
     * 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
     * <p>
     * 示例 1：
     * <p>
     * 输入：str1 = "ABCABC", str2 = "ABC"
     * 输出："ABC"
     * 示例 2：
     * <p>
     * 输入：str1 = "ABABAB", str2 = "ABAB"
     * 输出："AB"
     * 示例 3：
     * <p>
     * 输入：str1 = "LEET", str2 = "CODE"
     * 输出：""
     */
    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABCABC","ABC"));
    }
    public static String gcdOfStrings(String str1, String str2) {
        //判断str1+str2是否等于str2+str1
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        return str1.substring(0,gmt(str1.length(),str2.length()));
    }
    private static int gmt(int a,int b){
        //判断b是否等于0，如果等于0则返回a;
        return b==0?a:gmt(b,a%b);
    }
}
