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

package com.sandeep.gs;
import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    public static Character firstNonRepeatingChar(String str) {
        // Create a HashMap to store character frequencies
        Map<Character, Integer> charCountMap = new HashMap<>();

        // Step 1: Count the frequency of each character
      /*  for (char c : str.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
*/
        //Using map.merge
        for (char c : str.toCharArray()) {
            charCountMap.merge(c, 1, Integer::sum);
        }

        // Step 2: Find the first character that has a frequency of 1
        for (char c : str.toCharArray()) {
            if (charCountMap.get(c) == 1) {
                return c;
            }
        }

        // If no non-repeating character is found, return null
        return null;
    }

    public static void main(String[] args) {
        String str = "swiss";
        Character result = firstNonRepeatingChar(str);
        if (result != null) {
            System.out.println("The first non-repeating character is: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }
    }
}
