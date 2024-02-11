package org.lyflexi.solutions;

/**
 * @Author: ly
 * @Date: 2024/2/11 16:57
 */

/*
* 9. 回文数：夹逼法即可

给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
例如，121 是回文，而 123 不是。


示例 1：
输入：x = 121
输出：true
*
示例 2：
输入：x = -121
输出：false
解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
*
示例 3：
输入：x = 10
输出：false
解释：从右向左读, 为 01 。因此它不是一个回文数。
* */
public class Solution09_Palindrome {


    public boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }

        Integer wrapX = x;

        String strX = wrapX.toString();

        int n = strX.length();
        int left = 0;
        int right = n-1;

        while (left<right){
            char leftC = strX.charAt(left);
            char rightC = strX.charAt(right);
            if (leftC!=rightC){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
