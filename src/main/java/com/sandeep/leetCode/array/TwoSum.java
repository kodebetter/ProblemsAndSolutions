package com.sandeep.leetCode.array;


import java.lang.reflect.Array;
import java.util.List;

/**
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] tempArr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    tempArr[0] = i;
                    tempArr[1] = j;
                }
            }
        }
        return tempArr;
    }

    public static void main(String[] args) {
        int array[];
        array= new int[6];
    //adding elements to the array
        array[0] = 6;
        array[1] = 7;
        array[2] = 12;
        array[3] = 5;
        array[4] = 9;
        array[5] = 2;



        TwoSum twoSum = new TwoSum();
        int[] tempArr = twoSum.twoSum(array, 9);
        System.out.println("Temp arr "+ tempArr.toString());

    }

}
