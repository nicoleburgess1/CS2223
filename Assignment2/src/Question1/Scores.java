package Question1;

import java.util.Comparator;
public class Scores {
    private final int testScore;
    private final String studentName;

    public Scores(int grade, String student){
        testScore= grade;
        studentName=student;
    }
    public static class WhoGrade implements Comparator<Scores>
    {
        public int compare(Scores v, Scores w)
        {  return v.studentName.compareTo(w.studentName);  }
    }

    public static class Grade implements Comparator<Scores>
    {
        public int compare(Scores v, Scores w)
        {
            if (v.testScore < w.testScore) return -1;
            if (v.testScore > w.testScore) return +1;
            return 0;
        }
    }

    public int getTestScore(){
        return testScore;
    }
}

