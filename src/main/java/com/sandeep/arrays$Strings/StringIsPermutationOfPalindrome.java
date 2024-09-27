package com.sandeep.arrays$Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a String WAP to check if it is permutation of a palindrome string.
 */
public class  StringIsPermutationOfPalindrome {

    public boolean stringIsPermutationOfPalindrome(String str) {
        Map<String, Integer> stringMap = new HashMap<>();
        for (char ch : str.toLowerCase().toCharArray()) {
            if (stringMap.get(String.valueOf(ch)) == null) {
                stringMap.put(String.valueOf(ch), 1);
            } else {
                stringMap.put(String.valueOf(ch), stringMap.get(String.valueOf(ch)) + 1);
            }
        }
        int totalOnes = 0;
        for (Map.Entry<String, Integer> entry : stringMap.entrySet()) {
            if (entry.getValue().intValue() == 1) {
                totalOnes = totalOnes + 1;
            }
            if (totalOnes > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        StringIsPermutationOfPalindrome stringIsPermutationOfPalindrome = new StringIsPermutationOfPalindrome();
        System.out.println(stringIsPermutationOfPalindrome.stringIsPermutationOfPalindrome("TCTCOA"));
    }
}
