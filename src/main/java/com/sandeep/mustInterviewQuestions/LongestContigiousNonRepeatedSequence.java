package com.sandeep.mustInterviewQuestions;

public class LongestContigiousNonRepeatedSequence {

    public static void main(String[] args) {
        String input = "AABBCEEDF";
        String output = "ABE";
        findLongesRepeatingSubsequence(input);

    }

    public static void findLongesRepeatingSubsequence(String input) {
        int[][] dataMatrix = new int[input.length() + 1][input.length() + 1];
        int n = input.length();
        for (int i = 0; i <= input.length(); i++) {
            for (int j = 0; j <= input.length(); j++) {
                dataMatrix[i][j] = 0;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (input.charAt(i - 1) == input.charAt(j - 1) && i != j) {
                    dataMatrix[i][j] = 1 + dataMatrix[i - 1][j - 1];
                } else {
                    dataMatrix[i][j] = Math.max(dataMatrix[i][j - 1], dataMatrix[i - 1][j]);
                }
            }
        }

        String result = "";
        // Traverse dp[][] from bottom right
        int i = n, j = n;
        while (i > 0 && j > 0) {
            if (dataMatrix[i][j] == (dataMatrix[i - 1][j - 1] + 1)) {
                result = result + input.charAt(i - 1);
                i--;
                j--;
            } else if (dataMatrix[i][j] == dataMatrix[i - 1][j]) {
                i--;
            } else {
                j--;
            }
        }
        System.out.println("************* " + result);

    }
    
}
