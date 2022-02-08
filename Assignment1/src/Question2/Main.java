package Question2;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        //100 inputs
        int[] allowlist100 = IntStream.generate(() -> new Random().nextInt(1000)).limit(100).toArray();
        int key = allowlist100[50];
        Arrays.sort(allowlist100);
        LinearSearch.rank(key,allowlist100);
        BinarySearch.rank(key, allowlist100);
        BinaryRecursive.rankrecursive(key, allowlist100);
        System.out.println("100 inputs:");
        System.out.format( "steps %d in Linear Search\n", LinearSearch.steps ) ;
        System.out.format( "steps %d in Binary Search\n", BinarySearch.steps ) ;
        System.out.format( "steps %d in Binary Recursive\n", BinaryRecursive.steps ) ;
        BinaryRecursive.steps=0;
        LinearSearch.steps=0;
        BinarySearch.steps=0;

        //1000 inputs
        int[] allowlist1000 = IntStream.generate(() -> new Random().nextInt(1000)).limit(1000).toArray();
        key = allowlist1000[500];
        Arrays.sort(allowlist1000);
        LinearSearch.rank(key,allowlist1000);
        BinarySearch.rank(key, allowlist1000);
        BinaryRecursive.rankrecursive(key, allowlist1000);
        System.out.println("1,000 inputs:");
        System.out.format( "steps %d in Linear Search\n", LinearSearch.steps ) ;
        System.out.format( "steps %d in Binary Search\n", BinarySearch.steps ) ;
        System.out.format( "steps %d in Binary Recursive\n", BinaryRecursive.steps ) ;
        BinaryRecursive.steps=0;
        LinearSearch.steps=0;
        BinarySearch.steps=0;

        //10000 inputs
        int[] allowlist10000 = IntStream.generate(() -> new Random().nextInt(1000)).limit(10000).toArray();
        key = allowlist10000[5000];
        Arrays.sort(allowlist10000);
        LinearSearch.rank(key,allowlist10000);
        BinarySearch.rank(key, allowlist10000);
        BinaryRecursive.rankrecursive(key, allowlist10000);
        System.out.println("10,000 inputs:");
        System.out.format( "steps %d in Linear Search\n", LinearSearch.steps ) ;
        System.out.format( "steps %d in Binary Search\n", BinarySearch.steps ) ;
        System.out.format( "steps %d in Binary Recursive\n", BinaryRecursive.steps ) ;
        BinaryRecursive.steps=0;
        LinearSearch.steps=0;
        BinarySearch.steps=0;

        //100000 inputs
        int[] allowlist100000 = IntStream.generate(() -> new Random().nextInt(1000)).limit(100000).toArray();
        key = allowlist100000[50000];
        Arrays.sort(allowlist100000);
        LinearSearch.rank(key,allowlist100000);
        BinarySearch.rank(key, allowlist100000);
        BinaryRecursive.rankrecursive(key, allowlist100000);
        System.out.println("100,000 inputs:");
        System.out.format( "steps %d in Linear Search\n", LinearSearch.steps ) ;
        System.out.format( "steps %d in Binary Search\n", BinarySearch.steps ) ;
        System.out.format( "steps %d in Binary Recursive\n", BinaryRecursive.steps ) ;
        BinaryRecursive.steps=0;
        LinearSearch.steps=0;
        BinarySearch.steps=0;

        //250000 inputs
        int[] allowlist250000 = IntStream.generate(() -> new Random().nextInt(1000)).limit(250000).toArray();
        key = allowlist250000[50000];
        Arrays.sort(allowlist250000);
        LinearSearch.rank(key,allowlist250000);
        BinarySearch.rank(key, allowlist250000);
        BinaryRecursive.rankrecursive(key, allowlist250000);
        System.out.println("250,000 inputs:");
        System.out.format( "steps %d in Linear Search\n", LinearSearch.steps ) ;
        System.out.format( "steps %d in Binary Search\n", BinarySearch.steps ) ;
        System.out.format( "steps %d in Binary Recursive\n", BinaryRecursive.steps ) ;
        BinaryRecursive.steps=0;
        LinearSearch.steps=0;
        BinarySearch.steps=0;



    }
}
