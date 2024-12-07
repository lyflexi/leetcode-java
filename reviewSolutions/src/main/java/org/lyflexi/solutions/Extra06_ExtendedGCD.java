package org.lyflexi.solutions;

/**
 * @Description:
 * @Author: lyflexi
 * @project: leetcode-java
 * @Date: 2024/12/7 16:46
 */

import java.util.Arrays;

/**
 * 求解最大公约数, 同时计算出满足如下等式的系数x,y
 * ax+by = gcd
 *
 * 递归
 */
public class Extra06_ExtendedGCD {
    public static void main(String[] args) {
        int[] gcdArray = extendedGCD(21, 14);
        for (int v : gcdArray) {
            System.out.println(v);
        }
    }

    /**
     * 默认a>b
     * @param a
     * @param b
     * @return 三元组 g,x,y
     *
     * 假设在递归的某一步int[] gcdR = extendedGCD(b, a % b)，我们已经找到了整数x,y满足bx + (a%b)y = g(b,a%b), 求新一轮的g`,x`,y`
     *
     * 数学推导：
     * bx + (a%b)y = g(b,a%b)恒等于g(a,b)，记为常量g
     * bx + (a-|a/b|*b)y = g,其中|a/b|是整除
     * ay - b(x-|a/b|*y) = g
     *
     * 因此，新一轮的g`等于g
     * 新一轮的x = 上一轮的y = gcdR[2]
     * 新一轮的y = 上一轮的x-|a/b|*上一轮的y = gcdR[1] - |a/b|*gcdR[2]
     */
    private static int[] extendedGCD(int a, int b) {
        if (b == 0) {
            return new int[]{a,1,0};
        }
        int[] gcdR = extendedGCD(b, a % b);

        //新一轮的g恒等于常量 gcdR[0];
        int g = gcdR[0];
        //新一轮的x = 上一轮的y = gcdR[2]
        int x = gcdR[2];
        //新一轮的y = 上一轮的x-|a/b|*上一轮的y = gcdR[1] - |a/b|*gcdR[2]
        int y = gcdR[1] - (a/b)*gcdR[2];
        return new int[]{g,x, y};
    }
}
