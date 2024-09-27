package com.sandeep.arrays$Strings;

import java.util.HashMap;

public class TwoStringsArePermutation {

    public boolean stringPermutationBruteForce(String s1, String s2) {
        if(s1.length() == s2.length()) {
            for (char ch : s1.toCharArray()) {
                String s3 = (String.valueOf(ch));
                if (!s2.toLowerCase().contains(s3.toLowerCase())) {
                    return false;
                }
            }
            return true;
        }else {
            return false;
        }
    }
    public boolean stringPermutationMap(String s1, String s2) {
        HashMap<String,Integer> stringOneMap = new HashMap<>();
        if(s1.length() == s2.length()) {
            for (char ch : s1.toCharArray()) {
                String s3 = (String.valueOf(ch));
                if (stringOneMap.get(s3) == null) {
                    stringOneMap.put(s3, 1);
                } else {
                    stringOneMap.put(s3, stringOneMap.get(s3) + 1);
                }
            }
            for (char ch2 : s2.toCharArray()) {
                if (stringOneMap.get(String.valueOf(ch2)) == null) {
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        TwoStringsArePermutation twoStringsArePermutation = new TwoStringsArePermutation();
        System.out.println(twoStringsArePermutation.stringPermutationBruteForce("Anvee","vAnee"));
        System.out.println(twoStringsArePermutation.stringPermutationMap("Sandep","peednas"));
    }
}


