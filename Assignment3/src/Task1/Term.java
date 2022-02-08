package Task1;

import java.io.File;

public class Term {
    private String word;
    private String doc;
    private int freq;
    private double TFIDF;

    public Term(String w, String d, int f, double tfidf){
        word = w;
        doc = d;
        freq= f;
        TFIDF=tfidf;
    }

    public void increaseFreq(){
        freq++;
    }

    public String toString(){
        return word + " TFIDF = " + TFIDF;
    }

    public String getDoc(){
        return doc;
    }

    public String getWord(){
        return word;
    }

    public double getTFIDF(){
        return TFIDF;
    }

    public int getFreq(){
        return freq;
    }

    public void TFIDF(LinearProbingHashST allWords, int documents){
        TFIDF = Math.log(1+freq)*Math.log((double)documents/((Term)allWords.get(word)).getFreq());
    }

    public void TFIDF(BST allWords, int documents){
        TFIDF = Math.log(1+freq)*Math.log((double)documents/((Term)allWords.get(word)).getFreq());
    }
}