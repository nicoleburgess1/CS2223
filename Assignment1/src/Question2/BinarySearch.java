package Question2;

public class BinarySearch {
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


}
