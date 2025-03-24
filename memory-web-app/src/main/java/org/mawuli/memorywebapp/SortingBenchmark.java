package org.mawuli.memorywebapp;

import org.jetbrains.annotations.NotNull;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class SortingBenchmark {
    private int[] numbers;

    @Setup
    public void setup() {
        numbers = IntStream.range(0, 10000).map(i -> (int) (Math.random() * 10000)).toArray();
    }

    @Benchmark
    public void testBubbleSort() {
        bubbleSort(numbers.clone());
    }

    @Benchmark
    public void testQuickSort() {
        quickSort(numbers.clone(), 0, numbers.length - 1);
    }

    private void bubbleSort(@NotNull int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(@NotNull int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }


}



/*
* Category	Optimization Strategy
Code Optimization	Avoid redundant computations, optimize loops, use caching
Memory Management	Use object pooling, limit unnecessary object creation
Thread Management	Use thread pools, avoid excessive locking
Data Structure Selection	Use ArrayList over LinkedList when frequent random access is needed, use ConcurrentHashMap for multithreading
* */