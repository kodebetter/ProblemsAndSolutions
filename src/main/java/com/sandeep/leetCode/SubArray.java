package com.sandeep.leetCode;

import java.util.*;

/**
 * You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has unique characters.
 * <p>
 * Return the maximum possible length of s.
 * <p>
 * A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = ["un","iq","ue"]
 * Output: 4
 * Explanation: All the valid concatenations are "","un","iq","ue","uniq" and "ique".
 * Maximum length is 4.
 * Example 2:
 * <p>
 * Input: arr = ["cha","r","act","ers"]
 * Output: 6
 * Explanation: Possible solutions are "chaers" and "acters".
 * Example 3:
 * <p>
 * Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
 * Output: 26
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 16
 * 1 <= arr[i].length <= 26
 * arr[i] contains only lower case English letters.
 */

public class SubArray {

    public int getMinLengthSubArray(List<String> names) {
        Map<Character, Integer> charactersOccuranceMap = new HashMap<>();
        Set<Character> charactersCountSet = new HashSet<>();
        names.forEach(name -> {
                    char characters[] = name.toCharArray();
                    for (char c : characters) {
                        if(charactersOccuranceMap.get(c) != null){
                            if(charactersOccuranceMap.get(c) < characters.length){
                                charactersCountSet.remove(c);
                                charactersOccuranceMap.put(c, characters.length);
                            }
                        }else{
                            charactersOccuranceMap.put(c, characters.length);
                        }

                    }
                }
        );
        return charactersCountSet.size();
    }

    public static void main(String[] args) {
        SubArray array = new SubArray();
        List<String> names = new ArrayList<String>() {{
            add("cha");
            add("r");
            add("ect");
            add("ers");
        }};
        System.out.println("Length " + array.getMinLengthSubArray(names));
    }


}
