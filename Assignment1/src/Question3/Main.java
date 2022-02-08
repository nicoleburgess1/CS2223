package Question3;

import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[]args){
        Stopwatch timer1 = new Stopwatch();
        int[] allowlist1 = IntStream.generate(() -> new Random().nextInt(1000)).limit(100000).toArray();
        Functions.linear(allowlist1);
        System.out.println(timer1.elapsedTime());

        Stopwatch timer2 = new Stopwatch();
        int[] allowlist2 = IntStream.generate(() -> new Random().nextInt(1000)).limit(100000).toArray();
        Functions.quadratic(allowlist2);
        System.out.println(timer2.elapsedTime());

        Stopwatch timer3 = new Stopwatch();
        int[] allowlist3 = IntStream.generate(() -> new Random().nextInt(1000)).limit(10000).toArray();
        Functions.cubic(allowlist3);
        System.out.println(timer3.elapsedTime());

    }
}
