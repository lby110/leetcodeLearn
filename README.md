## day01-将数组分成和相等的三个部分
```java
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
```

## day02 字符串的最大公因子
```java
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
        //判断b是否等于0，如果等于0则返回a;递归算法
        return b==0?a:gmt(b,a%b);
    }
}
```

## day03 多数元素
```java
public class day03 {
    /**
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     * 示例 1:
     *
     * 输入: [3,2,3]
     * 输出: 3
     * 示例 2:
     *
     * 输入: [2,2,1,1,1,2,2]
     * 输出: 2
     */
    public static void main(String[] args) {
        int[] nums={2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
    public static int majorityElement(int[] nums) {
        int var1=0,var2=0;
        for(int num:nums){
            if(var1==0){
                var2=num;
            }
            var1=var1+(var2==num?1:-1);
        }
        return var2;
    }
}
```
