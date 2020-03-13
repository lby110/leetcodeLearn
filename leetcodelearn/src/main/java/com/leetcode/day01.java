package com.leetcode;

public class day01 {
    /**
     * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
     * <p>
     * 形式上，如果可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ...
     * + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
     * 事例1.
     * 输出：[0,2,1,-6,6,-7,9,1,2,0,1]
     * 输出：true
     * 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
     * 事例2.
     * 输入：[0,2,1,-6,6,7,9,-1,2,0,1]
     * 输出：false
     * 事例3.
     * 输入：[3,3,6,5,-2,2,5,1,-9,4]
     * 输出：true
     * 解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
     */
    public static void main(String[] args) {
        int[] A={3,3,6,5,-2,2,5,1,-9,4};
        System.out.println(canThreePartsEqualSum(A));
    }

    /**
     * 逻辑分析：假设可以分成三等份相等的值，那么所有的数加起来除以三则是每一部分加起来的值。那么可以得到一个结论sum/3=每一部分的值
     *
     * @param A
     * @return
     */
    public static boolean canThreePartsEqualSum(int[] A) {
        //1.定义一个sum用来存放数组A的和
        int sum = 0;
        for (int a : A) {
            sum += a;
        }
        //2.判断和除以三以后是否为0不为0则直接返回false
        if (!(sum % 3 == 0)) {
            return false;
        }
        int var1 = 0, var2 = 0;
        sum /= 3;
        for (int i = 0; i < A.length; i++) {
            var1 += A[i];
            if (var1 == sum) {
                var1 = 0;
                var2 += 1;
            }
        }
        //判断是否是三段，如果是0则不是三段，也需要返回
        return var2==3||(var2>3&&sum==0);
    }
}
