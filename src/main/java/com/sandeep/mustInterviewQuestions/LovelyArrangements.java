package com.sandeep.mustInterviewQuestions;

public class LovelyArrangements {



    public  class LovelyArrangementsBruteForce{
            int count = 0;
            public int countArrangement(int N) {
                int[] nums = new int[N];
                for (int i = 1; i <= N; i++)
                    nums[i - 1] = i;
                permute(nums, 0);
                return count;
            }
            public void permute(int[] nums, int l) {
                if (l == nums.length - 1) {
                    int i;
                    for (i = 1; i <= nums.length; i++) {
                        if (nums[i - 1] % i != 0 && i % nums[i - 1] != 0)
                            break;
                    }
                    if (i == nums.length + 1) {
                        count++;
                    }
                }
                for (int i = l; i < nums.length; i++) {
                    swap(nums, i, l);
                    permute(nums, l + 1);
                    swap(nums, i, l);
                }
            }
            public void swap(int[] nums, int x, int y) {
                int temp = nums[x];
                nums[x] = nums[y];
                nums[y] = temp;
            }
        }

    public class Solution { 
        int count = 0;
        public int countArrangement(int N) {
            boolean[] visited = new boolean[N + 1];
            calculate(N, 1, visited);
            return count;
        }
        public void calculate(int N, int pos, boolean[] visited) {
            if (pos > N)
                count++;
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                    visited[i] = true;
                    calculate(N, pos + 1, visited);
                    visited[i] = false;
                }
            }
        }
    }
}
