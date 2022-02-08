package Question5;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        //BubbleSort
        Stopwatch timer = new Stopwatch();
        int[] allowlist = IntStream.generate(() -> new Random().nextInt(1000)).limit(100).toArray();
        Bubblesort.sort(allowlist);
        System.out.println("BubbleSort 100: " + timer.elapsedTime());

        timer = new Stopwatch();
        allowlist = IntStream.generate(() -> new Random().nextInt(1000)).limit(1000).toArray();
        Bubblesort.sort(allowlist);
        System.out.println("BubbleSort 1,000: " + timer.elapsedTime());

        timer = new Stopwatch();
        allowlist = IntStream.generate(() -> new Random().nextInt(1000)).limit(10000).toArray();
        Bubblesort.sort(allowlist);
        System.out.println("BubbleSort 10,000: " + timer.elapsedTime());

        timer = new Stopwatch();
        allowlist = IntStream.generate(() -> new Random().nextInt(1000)).limit(100000).toArray();
        Bubblesort.sort(allowlist);
        System.out.println("BubbleSort 100,000: " + timer.elapsedTime());

        timer = new Stopwatch();
        allowlist = IntStream.generate(() -> new Random().nextInt(1000)).limit(250000).toArray();
        Bubblesort.sort(allowlist);
        System.out.println("BubbleSort 250,000: " + timer.elapsedTime());



        //MergeSort
        timer = new Stopwatch();
        allowlist = IntStream.generate(() -> new Random().nextInt(1000)).limit(100).toArray();
        Mergesort.sort(allowlist);
        System.out.println("MergeSort 100: " + timer.elapsedTime());

        timer = new Stopwatch();
        allowlist = IntStream.generate(() -> new Random().nextInt(1000)).limit(1000).toArray();
        Mergesort.sort(allowlist);
        System.out.println("MergeSort 1,000: " + timer.elapsedTime());

        timer = new Stopwatch();
        allowlist = IntStream.generate(() -> new Random().nextInt(1000)).limit(10000).toArray();
        Mergesort.sort(allowlist);
        System.out.println("MergeSort 10,000: " + timer.elapsedTime());

        timer = new Stopwatch();
        allowlist = IntStream.generate(() -> new Random().nextInt(1000)).limit(100000).toArray();
        Mergesort.sort(allowlist);
        System.out.println("MergeSort 100,000: " + timer.elapsedTime());

        timer = new Stopwatch();
        allowlist = IntStream.generate(() -> new Random().nextInt(1000)).limit(250000).toArray();
        Mergesort.sort(allowlist);
        System.out.println("MergeSort 250,000: " + timer.elapsedTime());



        //QuickSort
        timer = new Stopwatch();
        allowlist = IntStream.generate(() -> new Random().nextInt(1000)).limit(100).toArray();
        Quicksort.sort(allowlist);
        System.out.println("QuickSort 100: " + timer.elapsedTime());

        timer = new Stopwatch();
        allowlist = IntStream.generate(() -> new Random().nextInt(1000)).limit(1000).toArray();
        Quicksort.sort(allowlist);
        System.out.println("QuickSort 1,000: " + timer.elapsedTime());

        timer = new Stopwatch();
        allowlist = IntStream.generate(() -> new Random().nextInt(1000)).limit(10000).toArray();
        Quicksort.sort(allowlist);
        System.out.println("QuickSort 10,000: " + timer.elapsedTime());

        timer = new Stopwatch();
        allowlist = IntStream.generate(() -> new Random().nextInt(1000)).limit(100000).toArray();
        Quicksort.sort(allowlist);
        System.out.println("QuickSort 100,000: " + timer.elapsedTime());

        timer = new Stopwatch();
        allowlist = IntStream.generate(() -> new Random().nextInt(1000)).limit(250000).toArray();
        Quicksort.sort(allowlist);
        System.out.println("QuickSort 250,000: " + timer.elapsedTime());
    }
}
