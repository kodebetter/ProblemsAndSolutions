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

import java.util.HashMap;
import java.util.Map;

public class RateLimiter {
    private Map<Integer, Window> windows;

    public RateLimiter() {
        this.windows = new HashMap<>();
    }

    public synchronized boolean rateLimit(int customerId, int limit, int windowSizeInSeconds) {
        long currentTime = System.currentTimeMillis() / 1000;
        Window window = windows.getOrDefault(customerId, new Window(currentTime, 1));

        // If the current time is beyond the window's expiration time, reset the window
        if (currentTime > window.getStart() + windowSizeInSeconds) {
            window.setStart(currentTime);
            window.setCount(1);
        } else {
            // If within the window, check if the count exceeds the limit
            if (window.getCount() >= limit) {
                return false; // Rate limit exceeded
            }
            window.incrementCount();
        }

        windows.put(customerId, window);
        return true; // Request allowed
    }

    // Inner class representing the sliding window for each customer
    private static class Window {
        private long start;
        private int count;

        public Window(long start, int count) {
            this.start = start;
            this.count = count;
        }

        public long getStart() {
            return start;
        }

        public void setStart(long start) {
            this.start = start;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public void incrementCount() {
            count++;
        }
    }

    public static void main(String[] args) {
        RateLimiter limiter = new RateLimiter();
        int limit = 5;
        int windowSizeInSeconds = 10;

        // Simulate requests from multiple threads
        for (int i = 0; i < 5; i++) {
            int customerId = i ; // Vary customer ID for demonstration
            new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    boolean allowed = limiter.rateLimit(customerId, limit, windowSizeInSeconds);
                    System.out.println("Customer " + customerId + " - Request " + (j + 1) + ": " + (allowed ? "Allowed" : "Rate limit exceeded"));
                    try {
                        Thread.sleep(100); // Simulating requests coming in every second
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
