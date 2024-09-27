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

public class RobotBoundedInCircle {

    public static boolean isRobotBounded(String instructions) {
        // Initial position and direction (facing north)
        int x = 0, y = 0; // Initial position
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // N, E, S, W
        int dir = 0; // Initially facing north (index 0 in directions)

        for (char instruction : instructions.toCharArray()) {
            if (instruction == 'G') {
                // Move in the current direction
                x += directions[dir][0];
                y += directions[dir][1];
            } else if (instruction == 'L') {
                // Turn left -> counterclockwise: dir = (dir + 3) % 4
                dir = (dir + 3) % 4;
            } else if (instruction == 'R') {
                // Turn right -> clockwise: dir = (dir + 1) % 4
                dir = (dir + 1) % 4;
            }
        }

        // The robot is bounded if:
        // 1. It returns to the origin, or
        // 2. It doesn't face north (it must eventually come back)
        return (x == 0 && y == 0) || (dir != 0);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(isRobotBounded("GGLLGG")); // true (bounded in a circle)
        System.out.println(isRobotBounded("GG")); // false (keeps going straight)
        System.out.println(isRobotBounded("GL")); // true (turns around and comes back)
    }
}