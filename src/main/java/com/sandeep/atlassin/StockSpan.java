/*
 * *
 *  * Copyright ${YEAR} ${USER}
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.sandeep.atlassin;

import java.util.Arrays;

public class StockSpan {

    // method to calculate stock span values
    static void calculateSpan(int price[], int n, int S[])
    {
        // Span value of first day is always 1
        S[0] = 1;

        // Calculate span value of remaining days by
        // linearly checking previous days
        for (int i = 1; i < n; i++) {
            S[i] = 1; // Initialize span value

            // Traverse left while the next element on left
            // is smaller than price[i]
            for (int j = i - 1; (j >= 0); j--)
                if(price[i] >= price[j]) {
                S[i]++;
            }
        }
    }

    // A utility function to print elements of array
    static void printArray(int arr[])
    {
        System.out.print(Arrays.toString(arr));
    }

    // Driver code
    public static void main(String[] args)
    {
        int price[] = { 10, 4, 5, 90, 120, 80 };
        int n = price.length;
        int S[] = new int[n];

        // Fill the span values in array S[]
        calculateSpan(price, n, S);

        // print the calculated span values
        printArray(S);
    }
}
