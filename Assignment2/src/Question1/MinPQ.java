package Question1;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class MinPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N;
    private Comparator<Key> comparator;

    public MinPQ(int initCapacity) {
        pq = (Key[]) new Comparable[initCapacity + 1];
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key x) {
        // double size of array if necessary
        if (N == pq.length - 1) resize(2 * pq.length);

        // add x, and percolate it up to maintain heap invariant
        pq[++N] = x;
        swim(N);
        assert isMinHeap();
    }

    public Key delMin() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        Key min = pq[1];
        exch(1, N--);
        sink(1);
        pq[N+1] = null;     // to avoid loitering and help with garbage collection
        if ((N > 0) && (N == (pq.length - 1) / 4)) resize(pq.length / 2);
        assert isMinHeap();
        return min;
    }

    private void swim(int k) {
        while (k > 1 && greater(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private boolean greater(int i, int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
        }
        else {
            return comparator.compare(pq[i], pq[j]) > 0;
        }
    }

    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    private boolean isMinHeap() {
        for (int i = 1; i <= N; i++) {
            if (pq[i] == null) return false;
        }
        for (int i = N+1; i < pq.length; i++) {
            if (pq[i] != null) return false;
        }
        if (pq[0] != null) return false;
        return isMinHeapOrdered(1);
    }

    private boolean isMinHeapOrdered(int k) {
        if (k > N) return true;
        int left = 2*k;
        int right = 2*k + 1;
        if (left  <= N && greater(k, left))  return false;
        if (right <= N && greater(k, right)) return false;
        return isMinHeapOrdered(left) && isMinHeapOrdered(right);
    }

    private void resize(int capacity) {
        assert capacity > N;
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= N; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    public String toString(){
        String s= "";
        for(Key i: pq){
            s+= i + " ";
        }
        return s;
    }
}
