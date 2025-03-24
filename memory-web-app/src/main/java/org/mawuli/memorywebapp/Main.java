package org.mawuli.memorywebapp;

public class Main {
    public static void main(String[] args) {
        SortingBenchmark sortingBenchmark = new SortingBenchmark();
        sortingBenchmark.setup();
        sortingBenchmark.testBubbleSort();
        sortingBenchmark.testQuickSort();
    }
}
