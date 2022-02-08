package Question2;

public class BinaryRecursive {
    public static int steps = 0;

    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while( lo <= hi )
        {
            steps++;
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static int rankrecursive(int key, int[] a) {
        return rankrecursive(key, a, 0, a.length - 1);
    }

    public static int rankrecursive(int key, int[] a, int lo, int hi) {
        steps++;
        if( lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if( key < a[mid]) return rankrecursive(key, a, lo, mid-1);
        else if(key > a[mid]) return rankrecursive(key, a, mid+1, hi);
        else return mid;
    }

}
