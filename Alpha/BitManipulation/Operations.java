package Alpha.BitManipulation;

public class Operations {
    //Get ith bit =>
    public static int get_ithBit(int n ,int i){
        // n & (1<<i)
        int bitMask = 1<<i;
        if((n&bitMask)==0){
            return 0;
        }
        else
            return 1;
    }

    //Set ith bit =>
    public static int set_ithBit(int n ,int i) {
        // n | (1<<i)
        int bitMask = 1 << i;
        n = n | bitMask;
        return n;
    }

    //Clear ith bit =>
    public static int clear_ithBit(int n ,int i) {
        // n & ~(1<<i)
        int bitMask = ~(1<<i);
        return n & bitMask;
    }

    // Update Bit ;
    public static int updateIthBIt(int n , int i , int newBit){
//        if(newBit==0){
//            return clear_ithBit(n,i);
//        }
//        else{
//            return set_ithBit(n,i);
//        }

        n = clear_ithBit(n,i);
        int bitMask = (newBit<<i);
        return n | bitMask;
    }


    //Clear Last Ith Bits
    public static int clearLastithBitS(int n ,int i) {
        // n & (-1<<i) or n &(~0 << i);
//        int bitMask = ((-1)<<i);
        int bitMask = ((~0)<<i);
        return n & bitMask;
    }

    //Clear Range of Bits i to j;
    public static int clearRangeOfBits(int n , int i , int j ){
        int a = (-1<<j+1);
        int b = (1<<i)-1;
        int bitMAsk = a|b;
        return n&bitMAsk;
    }


        public static void main (String[]args){
            System.out.println("getithbit of 10 , 2 : " + get_ithBit(10, 2)); //0

            System.out.println("Setithbit of 10 , 2 : " + set_ithBit(10, 2)); //14

            System.out.println("Clear_ithbit of 10 , 1 : " + clear_ithBit(10, 12)); //8


            System.out.println("Update_ithbit of 10 , 2 ,1 : " + updateIthBIt(10,2,1));

            System.out.println("ClearLastIthBits of 15 , 2 : " + clearLastithBitS(15,2));

            System.out.println("Clear Range of bits i to j : " + clearRangeOfBits(10,2,4));
        }
    }
