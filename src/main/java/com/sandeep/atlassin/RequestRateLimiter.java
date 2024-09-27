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

public class RequestRateLimiter {

    Map<String, Window> customerWindowMap = new HashMap<>();
    long windowSizeInseconds = 1;

    public synchronized boolean isRequestAllowed(String customerId, Integer limit) {
        long currrentTime = System.currentTimeMillis() / 1000;
        Window customerWindow = customerWindowMap.getOrDefault(customerId, new Window(1, currrentTime));
        if (currrentTime > customerWindow.getStartTime() + windowSizeInseconds) {
            customerWindow.setStartTime(currrentTime);
            customerWindow.setRequestCount(1);
        } else {
            if (customerWindow.getRequestCount() >= limit) {
                return false;
            }
            customerWindow.setRequestCount(customerWindow.getRequestCount() + 1);
        }
        customerWindowMap.put(customerId, customerWindow);
        return true;
    }


    public static void main(String[] args) {
        RequestRateLimiter requestRateLimiter = new RequestRateLimiter();
        for (int i = 0; i < 3; i++) {
            String customerId = "CustomerId_" + i;
            new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    boolean isRequestAllowed = requestRateLimiter.isRequestAllowed(customerId, 2);
                    if(isRequestAllowed){
                        System.out.println("Processing "+ customerId + "request Number " + j);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else {
                        System.out.println("Go to hell you are given 429");
                    }

                }
            }).start();

        }


    }

    private static class Window {
        Integer requestCount;
        long startTime;

        public Window(Integer requestCount, long startTime) {
            this.requestCount = requestCount;
            this.startTime = startTime;
        }

        public Integer getRequestCount() {
            return requestCount;
        }

        public void setRequestCount(Integer requestCount) {
            this.requestCount = requestCount;
        }

        public long getStartTime() {
            return startTime;
        }

        public void setStartTime(long startTime) {
            this.startTime = startTime;
        }
    }

}
