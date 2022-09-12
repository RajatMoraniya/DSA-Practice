package Alpha.BitManipulation;

public class CountSetBits {
    public static int countSetBits(int n){
        //count set bits means counting all 1's ;
        int count  = 0;
        while(n>0){
            if((n&1) != 0){  // n&1 == LSB checking LSB 0 or not if not zero than count++
            count++;
            }
            n = n>>1;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countSetBits(10)); //1010 => 1's = 2 ;
        System.out.println(countSetBits(15)); //01111 => 1's = 4 ;
        System.out.println(countSetBits(16)); //10000 => 1's = 1 ;
    }
}
