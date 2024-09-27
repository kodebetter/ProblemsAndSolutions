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

public class ReachingPoints {

    public static boolean canReach(int sx, int sy, int tx, int ty) {
        // Work backwards from (tx, ty) to (sx, sy)
        while (tx >= sx && ty >= sy) {
            if (tx == sx && ty == sy) {
                return true; // We have reached the starting point
            }
            if (tx > ty) {
                // Reduce tx by using modulo with ty
                if (ty > sy) {
                    tx %= ty;
                } else { // ty == sy, only possible if tx is a multiple of ty
                    return (tx - sx) % ty == 0;
                }
            } else {
                // Reduce ty by using modulo with tx
                if (tx > sx) {
                    ty %= tx;
                } else { // tx == sx, only possible if ty is a multiple of tx
                    return (ty - sy) % tx == 0;
                }
            }
        }
        return false; // If either tx or ty is smaller than sx or sy, it's impossible to reach
    }

    public static void main(String[] args) {
        System.out.println(canReach(1, 1, 3, 5));  // Output: true
        System.out.println(canReach(1, 1, 2, 2));  // Output: false
        System.out.println(canReach(1, 1, 1, 1));  // Output: true
    }
}
