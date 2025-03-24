package org.mawuli;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WordCounter {
    private static final ConcurrentHashMap<String, Integer> wordCounts = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        String[] words = {"apple", "banana", "apple", "orange", "banana", "apple"};

        try (ExecutorService executor = Executors.newFixedThreadPool(3)) {
            for (String word : words) {
                executor.submit(() -> wordCounts.merge(word, 1, Integer::sum));
            }

            executor.shutdown();
            while (!executor.isTerminated()) {
            }

            System.out.println("Word counts: " + wordCounts);
        }


    }
}


//Summary
//Garbage Collection: Prevent memory leaks, optimize GC performance.
//Threading: Use ExecutorService for concurrent tasks.
//Fork/Join: Break tasks into smaller subtasks for parallel execution.
//Concurrent Collections: Use ConcurrentHashMap for thread-safe data sharing.