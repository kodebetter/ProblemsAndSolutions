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


import java.util.*;

public class MajorityElement {

    // function to sort hashmap by values
    public static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hashMap) {
        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Integer>> list =
                new LinkedList<>(hashMap.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    // Driver Code
    public static void main(String[] args) {

        //int arr[] = {1, 1, 2, 1, 3, 5, 1};
        //int arr[] ={3, 3, 4, 2, 4, 4, 2, 4, 4};
        int arr[] ={3, 3, 4, 2, 4, 4, 2, 4};
        int n = arr.length;

        HashMap<Integer, Integer> hashMapCounter = new HashMap<Integer, Integer>();
        for (int i : arr) {
            hashMapCounter.merge(i, 1, Integer::sum);
        }
        int result = 0;
        int totalCount = 0;
        Map<Integer, Integer> hm1 = sortByValue(hashMapCounter);
        for (Map.Entry<Integer, Integer> entry : hm1.entrySet()) {
            if (entry.getValue() > arr.length / 2) {
                result = entry.getKey();
                totalCount = totalCount + 1;
                if (totalCount > 1) {
                    System.out.println("Majority Element is None ");
                    System.exit(0);
                }
            }
        }
        System.out.println("Majority Element is "+ result);
        // print the sorted hashmap

    }
}
