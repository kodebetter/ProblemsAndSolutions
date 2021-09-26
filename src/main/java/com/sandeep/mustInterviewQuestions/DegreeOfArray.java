package com.sandeep.mustInterviewQuestions;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DegreeOfArray {

    /**
     * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum
     * frequency of any one of its elements.
     * <p>
     * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
     * Input: nums = [1,2,2,3,1]
     * Output: 2
     * Explanation:
     * The input array has a degree of 2 because both elements 1 and 2 appear twice.
     * Of the subarrays that have the same degree:
     * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
     * The shortest length is 2. So return 2.
     *
     */
//Approach 1 Single Loop

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>() ;
        Map<Integer, Integer> visitMap = new HashMap<>() ;
        int degree = 0;
        int minLength =0 ;
        for (int i = 0; i < nums.length ; i++) {
            visitMap.putIfAbsent(nums[i], i);
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) +1);
            if(frequencyMap.get(nums[i]) > degree){
               degree =  frequencyMap.get(nums[i]);
               minLength = i - (visitMap.get(nums[i]) + 1);
            }else if(frequencyMap.get(nums[i]) == degree){
                minLength = Math.min(minLength, i - (visitMap.get(nums[i]) + 1));
            }
        }
        return minLength;
    }

//Approach 2 double Loop

}


