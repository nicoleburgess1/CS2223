package Task1;

import java.util.Iterator;

public class LinearProbingHashST<Key, Value>
{
    private int N;
    private int M = 16;
    private Key[] keys;
    private Value[] vals;  // the values
    // number of key-value pairs in the table
// size of linear-probing table
// the keys
    public LinearProbingHashST()
    {
        keys = (Key[])   new Object[M];
        vals = (Value[]) new Object[M];
    }

    public LinearProbingHashST(int c)
    {
        M=c;
        keys = (Key[])   new Object[M];
        vals = (Value[]) new Object[M];
    }

    private int hash(Key key)
    {  return (key.hashCode() & 0x7fffffff) % M; }

    private void resize(int cap)
    {
        LinearProbingHashST<Key, Value> t;
        t = new LinearProbingHashST<Key, Value>(cap);
        for (int i = 0; i < M; i++)
            if (keys[i] != null)
                t.put(keys[i], vals[i]);
        keys = t.keys;
        vals = t.vals;
        M    = t.M;
    }

    public void put(Key key, Value val)
    {
        if (N >= M/2) resize(2*M);  // double M (see text)
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (keys[i].equals(key)) { vals[i] = val; return; }
        keys[i] = key;
        vals[i] = val;
        N++; }

    public Value get(Key key)
    {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (keys[i].equals(key))
                return vals[i];
        return null;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < M; i++)
            if (keys[i] != null) queue.enqueue(keys[i]);
        return queue;
    }

    private class ArrayIterator implements Iterator<Value> {
        private int i = 0;

        public boolean hasNext() {
            return i < M;
        }

        public Value next() {
            return vals[i++];
        }

        public void remove() {
        }
    }
}
