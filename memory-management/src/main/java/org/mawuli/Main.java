package org.mawuli;

import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        //Exercise 2
        int[] array = {10,10,10,10,1,9};
        SumTask sumTask = new SumTask(array, 0, array.length);
        try(ForkJoinPool forkJoinPool = ForkJoinPool.commonPool()) {
            System.out.println(forkJoinPool.invoke(sumTask));
        }

    }
}