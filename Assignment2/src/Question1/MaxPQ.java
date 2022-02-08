package Question1;

import java.util.Comparator;

public class MaxPQ<Key extends Comparable<Key>>
{
    private Key[] pq; // heap-ordered complete binary tree
    private int N = 0; // in pq[1..N] with pq[0] unused
    private Comparator<Key> comparator;

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN+1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v){
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1]; // Retrieve max key from top.
        exch(1, N--); // Exchange with last item.
        pq[N+1] = null; // Avoid loitering.
        sink(1); // Restore heap property.
        return max;
    }
    // See pages 145-147 for implementations of these helper methods.
    private boolean less(int i, int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) < 0;
        }
        else {
            return comparator.compare(pq[i], pq[j]) < 0;
        }
    }

    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(j, j+1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
}