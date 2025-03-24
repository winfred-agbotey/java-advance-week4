package org.mawuli;

import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Long> {
    private static final int THRESHOLD = 500;
    private final int[] array;
    private final int start, end;

    public SumTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long sum = 0L;
        if ((end - start) <= THRESHOLD) {
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        }
        int mid = (start + end) >>> 1;
        SumTask leftTask = new SumTask(array, start, mid);
        SumTask rightTask = new SumTask(array, mid, end);

        leftTask.fork();
        rightTask.fork();
        return leftTask.join() + rightTask.join();

    }
}
