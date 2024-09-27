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
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VotingSystem {

    Map<String, Integer> voterVotesMap;

    public VotingSystem() {
        voterVotesMap = new HashMap<>();
    }

    public synchronized void voteForCandidate(String candidate) {
        voterVotesMap.put(candidate, voterVotesMap.getOrDefault(candidate, 0) + 1);
    }

    public String getWinner() {
        String winner = "";
        int maxVotes = 0;
        for (Map.Entry<String, Integer> vote : voterVotesMap.entrySet()) {
            System.out.println("Candidate "+ vote.getKey() + " votes "+ vote.getValue());
            if (vote.getValue() > maxVotes) {
                maxVotes = vote.getValue();
                winner = vote.getKey();

            }
        }
        return winner;
    }

    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();
        ExecutorService executorService = Executors.newFixedThreadPool(10); // Using 10 threads

        // Simulate constant stream of votes
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            executorService.submit(() -> {
                String candidate = "Candidate" + (random.nextInt(5) + 1); // Randomly select a candidate
                votingSystem.voteForCandidate(candidate);
            });
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Get the winner
        String winner = votingSystem.getWinner();
        if (winner != null) {
            System.out.println("Winner: " + winner);
        } else {
            System.out.println("No votes cast yet");
        }
    }


}

