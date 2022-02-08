package Task1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[]args){
        LinearProbingHashST[] hashTable = new LinearProbingHashST[14];

        //initialize hashtable
        for(int i=0; i< hashTable.length; i++)
        {
            hashTable[i]= new LinearProbingHashST();
        }

        //list of all file names
        String[] textFileNames = new String[14];
        textFileNames[0]  = "bustopher-jones-the-cat-about-town.txt";
        textFileNames[1]  = "growltigers-last-stand.txt";
        textFileNames[2]  = "gus-the-theater-cat.txt";
        textFileNames[3]  = "macavity-the-mystery-cat.txt";
        textFileNames[4]  = "mr-mistoffelees.txt";
        textFileNames[5]  = "mungojerrie-and-rumpelteazer.txt";
        textFileNames[6]  = "of-the-awefull-battle-of-the-pekes-and-the-pollicles.txt";
        textFileNames[7]  = "old-deuteronomy.txt";
        textFileNames[8]  = "skimbleshanks-the-railway-cat.txt";
        textFileNames[9]  = "the-ad-dressing-of-cats.txt";
        textFileNames[10] = "the-naming-of-cats.txt";
        textFileNames[11] = "the-old-gumbie-cat.txt";
        textFileNames[12] = "the-rum-tum-tugger.txt";
        textFileNames[13] = "the-song-of-the-jellicles.txt";


        Stopwatch timer2 = new Stopwatch();
        String[] fileWords = new String[14];

        for(int j= 0; j< textFileNames.length; j++) {
            fileWords[j] = "";
            try {
                File myObj = new File("/Users/nicoleburgess/CS/CS2223/Assignment3/data/" + textFileNames[j]);
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    fileWords[j] += data;
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

            String[] words = fileWords[j].toLowerCase().replaceAll("'", "").replaceAll("-", "").replaceAll("—", " ").split("[\\s\\p{Punct}]+");


            for (int i = 0; i < words.length; i++) {
                if(hashTable[j].get(words[i])==null)
                    hashTable[j].put(words[i], new Term(words[i], textFileNames[j], 1, 0));
                else
                    ((Term)hashTable[j].get(words[i])).increaseFreq();
            }
        }
        System.out.println("Construct hashtable: " + timer2.elapsedTime());

        LinearProbingHashST allWords = new LinearProbingHashST();
        String filewords= "";
        for(int j= 0; j< textFileNames.length; j++) {
            try {
                File myObj = new File("/Users/nicoleburgess/CS/CS2223/Assignment3/data/" + textFileNames[j]);
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    filewords += data;
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

        }

        String[] allwords = filewords.toLowerCase().replaceAll("'", "").replaceAll("-", "").replaceAll("—", " ").split("[\\s\\p{Punct}]+");
        for (int i = 0; i < allwords.length; i++) {
            if(allWords.get(allwords[i])==null)
                allWords.put(allwords[i], new Term(allwords[i], textFileNames[0], 1, 0));
            else
                ((Term)allWords.get(allwords[i])).increaseFreq();

        }

        for(int i=0; i< hashTable.length; i++){
            String[] words = fileWords[i].toLowerCase().replaceAll("'", "").replaceAll("-", "").replaceAll("—", " ").split("[\\s\\p{Punct}]+");
            for(int j=0; j<words.length; j++){
                if(hashTable[i].get(words[j])!=null){
                    ((Term)hashTable[i].get(words[j])).TFIDF(allWords, hashTable.length);
                }
            }
        }

        //using search
        search("all", hashTable);
        System.out.println("\n");
        search("bones", hashTable);
        System.out.println("\n");
        search("and", hashTable);
        System.out.println("\n");

        //using top10
        for(int i = 0; i< textFileNames.length; i++){
            top10(textFileNames[i], hashTable[i]);
            System.out.println();
        }

        //step 12
        Queue queue = (Queue)allWords.keys();
        Stopwatch timer1 = new Stopwatch();
        for(int i=0; i<queue.size()/10; i++){
                search(queue.dequeue(), hashTable);
        }
        System.out.println("Search Hashtable: " + timer1.elapsedTime());


        BST[] bsts = new BST[14];
        for(int i= 0; i< bsts.length; i++){
            bsts[i] = new BST();
        }

        //step 13
        //using fileWords array already created
        Stopwatch timer3 = new Stopwatch();
        for(int i= 0; i< bsts.length; i++){
            String[] words = fileWords[i].toLowerCase().replaceAll("'", "").replaceAll("-", "").replaceAll("—", " ").split("[\\s\\p{Punct}]+");
            for(int j= 0; j<words.length; j++){
                if(bsts[i].get(words[j])==null)
                    bsts[i].put(words[j], new Term(words[j], textFileNames[i], 1, 0));
                else
                    ((Term)bsts[i].get(words[j])).increaseFreq();
            }
        }
        System.out.println("Construct BST: " + timer3.elapsedTime());

        //using filewords from before
        BST all = new BST();
        for (int i = 0; i < allwords.length; i++) {
            if(all.get(allwords[i])==null)
                all.put(allwords[i], new Term(allwords[i], textFileNames[0], 1, 0));
            else
                ((Term)all.get(allwords[i])).increaseFreq();

        }

        for(int i=0; i< bsts.length; i++){
            String[] words = fileWords[i].toLowerCase().replaceAll("'", "").replaceAll("-", "").replaceAll("—", " ").split("[\\s\\p{Punct}]+");
            for(int j=0; j<words.length; j++){
                if(bsts[i].get(words[j])!=null){
                    ((Term)bsts[i].get(words[j])).TFIDF(all, bsts.length);
                }
            }
        }

        Queue queueBST = (Queue)all.keys();
        Stopwatch timer4 = new Stopwatch();
        for(int i=0; i<queue.size()/10; i++){
            search(queueBST.dequeue(), bsts);
        }
        System.out.println("Search BST: " + timer4.elapsedTime());


    }

    public static <Key> void search(Key searchKey, LinearProbingHashST[] hashTable) {
        System.out.println(searchKey);
        for(int i = 0; i< hashTable.length; i++){
            if(hashTable[i].get(searchKey)!=null){
                System.out.println("Doc " + (i+1) + ": " + ((Term)hashTable[i].get(searchKey)).getDoc() + " Freq: " + ((Term)hashTable[i].get(searchKey)).getFreq() + " TFIDF: " + ((Term)hashTable[i].get(searchKey)).getTFIDF());
            }
        }
    }

    public static <Key> void search(Key searchKey, BST[] bsts) {
        System.out.println(searchKey);
        for(int i = 0; i< bsts.length; i++){
            if(bsts[i].get((Comparable) searchKey)!=null){
                System.out.println("Doc " + (i+1) + ": " + ((Term)bsts[i].get((Comparable) searchKey)).getDoc() + " Freq: " + ((Term)bsts[i].get((Comparable) searchKey)).getFreq() + " TFIDF: " + ((Term)bsts[i].get((Comparable) searchKey)).getTFIDF());
            }
        }
    }

    public static void top10(String doc, LinearProbingHashST table){
        String fileWords = "";
        try {
            File myObj = new File("/Users/nicoleburgess/CS/CS2223/Assignment3/data/" + doc);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                fileWords += data;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        String[] words = fileWords.toLowerCase().replaceAll("'", "").replaceAll("-", "").replaceAll("—", " ").split("[\\s\\p{Punct}]+");


        for (int i = 0; i < words.length; i++) {
            if(table.get(words[i])==null)
                table.put(words[i], new Term(words[i], doc, 1, 0));
            else
                ((Term)table.get(words[i])).increaseFreq();
        }

        Term[] terms = new Term[10];

        for(int i =0; i< words.length; i++){
            double TFIDF = ((Term)table.get(words[i])).getTFIDF();
            for(int j = 0; j<terms.length; j++){
                if(terms[j]==null){
                    terms[j]=(Term)table.get(words[i]);
                    break;
                }
                if(terms[j].getWord().equals(words[i]))
                    break;
                else if(((Term)table.get(words[i])).getTFIDF()>terms[j].getTFIDF()){
                    Term insert = (Term)table.get(words[i]);
                    for(int k=j; k<terms.length; k++){
                        Term temp = insert;
                        insert = terms[k];
                        terms[k]= temp;
                    }
                    break;
                }
            }
        }

        for(int i = 0; i< terms.length; i++){
            System.out.println(i+1 + ". " + terms[i]);
        }
    }

}