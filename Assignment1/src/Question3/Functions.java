package Question3;

public class Functions {

    public static int linear(int[] a){
        int sum = 0;

        for(int i= 0; i<a.length; i++){
            sum+=a[i];
        }
        return sum;
    }

    public static int quadratic(int[] a){
        int sum = 0;
        for(int i= 0; i<a.length; i++){
            for(int j=0; j<a.length; j++){
                sum+=a[j];
            }
        }
        return sum;
    }

    public static int cubic(int[] a){
        int sum = 0;
        for(int i= 0; i<a.length; i++){
            for(int j=0; j<a.length; j++){
               for(int k=0; k<a.length; k++){
                   sum+=a[k];
               }
            }
        }
        return sum;
    }
}
