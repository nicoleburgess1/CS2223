package Question2;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main<Key extends Comparable<Key>> {
    public static void main(String[]args){
        int[] allowlist = IntStream.generate(() -> new Random().nextInt(1000)).limit(250000).toArray();
        Integer[] allowlistInteger = Arrays.stream( allowlist ).boxed().toArray( Integer[]::new );
        Integer[] allowlistIntegerQS = Arrays.stream( allowlist ).boxed().toArray( Integer[]::new );
        Integer[] allowlistIntegerIS = Arrays.stream( allowlist ).boxed().toArray( Integer[]::new );
        allowlistInteger = add2BeginningOfArray(allowlistInteger, 0);


        Stopwatch timer1 = new Stopwatch();
        HeapSort.sort(allowlistInteger);
        double time1 = timer1.elapsedTime();
        System.out.println("heapsort 250k " + time1);
        System.out.println("is sorted " + HeapSort.isSorted(allowlistInteger));

        Stopwatch timer2 = new Stopwatch();
        QuickSortLH.sort(allowlistIntegerQS);
        double time2 = timer2.elapsedTime();
        System.out.println("quicksort 250k " + time2);
        System.out.println("is sorted " + QuickSortLH.isSorted(allowlistIntegerQS));

        Stopwatch timer3 = new Stopwatch();
        Insertion.sort(allowlistIntegerIS);
        double time3 = timer3.elapsedTime();
        System.out.println("insertsort 250k " + time3);
        System.out.println("is sorted " + Insertion.isSorted(allowlistIntegerIS));
    }

    public static <T> T[] add2BeginningOfArray(T[] elements, T element) {
        T[] newArray = Arrays.copyOf(elements, elements.length + 1);
        newArray[0] = element;
        System.arraycopy(elements, 0, newArray, 1, elements.length);

        return newArray;
    }
}
