package Question1;

import java.util.Random;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[]args){
        int[] allowlist = IntStream.generate(() -> new Random().nextInt(200)).limit(100).toArray();

        MinPQ list = new MinPQ(100);

        for(int i: allowlist){
            list.insert(i);
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(list);

        System.out.println(list.delMin());
        System.out.println(list);

        Scores[] grades = new Scores[6];
        grades[1]= new Scores(99, "Nicole");
        grades[2]= new Scores(85, "Grace");
        grades[3]= new Scores(87, "Maggie");
        grades[4]= new Scores(62, "Julie");
        grades[5]= new Scores(100, "Amber");

        MinPQ scores = new MinPQ(5);

        for(int i=1; i<grades.length; i++){
            scores.insert(grades[i].getTestScore());
        }

        System.out.println(scores);
        scores.delMin();
        System.out.println(scores);


    }
}
