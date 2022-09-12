package Hasshing;
import java.util.*;

    class RemoveDup
    {
        public static void SortArray(int a[], int b[], int res[], int n, int m)
        {
            int i=0, j=0, k=0;
            while (i < n){
                res[k] = a[i];
                i++;
                k++;
            }
            while (j < m) {
                res[k] = b[j];
                j++;
                k++;
            }
            Arrays.sort(res);

        }

        static int removeDuplicates(int res[], int a){

            if(a == 0 || a ==1 ){
                return a;
            }

            int j= 0 ;
            for(int i= 0; i <a-1; i++ )
                if(res[i] !=res [i+1])
                    res[j++]= res [i];
            res[j++] = res [a-1];

            return j;


        }

        public static void main(String[] args) {

            int a[] = {9,9,10,10,1};
            int b[] = {81,71,1,4};
            int n = a.length;
            int m = b.length;
            int res[] = new int[ n + m];
            SortArray(a, b, res, n, m);
            System.out.println("Sorted merged list");

            for (int i= 0 ; i < n+ m ;i++){
                System.out.print(res[i] + " ");
            }

            //------------------------------------------

            int h = res.length;
            h =removeDuplicates(res, h);
            System.out.println();

            System.out.println("Printing element after removing duplicates");
            for (int i=0; i<h; i++){
                System.out.print(res[i]+" ");
            }
        }
    }
