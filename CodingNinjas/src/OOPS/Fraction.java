package OOPS;

class ZeroDenominatorException extends Exception{

}

public class Fraction {
    private int numerator;
    private int demoninator;

    Fraction(int numerator ,int demoninator){
        this.numerator = numerator;
        if(demoninator == 0){
            //TODO error out
        }
        this.demoninator = demoninator;
        simplyfy();
    }

    public void setNumerator(int n){
        this.numerator = n;
        simplyfy();
    }

    public void setDemoninator(int d) throws ZeroDenominatorException{
        if(d==0){
            ZeroDenominatorException e = new ZeroDenominatorException();
            throw e;
        }
        this.demoninator = d;
        simplyfy();
    }

    public int getNumerator(){
        return numerator;
    }

    public int getDemoninator(){
        return demoninator;
    }
    private void simplyfy(){
        int gcd = 1;
        for(int i = 2 ; i <= Math.min(numerator,demoninator);i++){
            if(numerator%i==0 && demoninator%i==0){
                gcd = i;
            }
        }
        numerator = numerator/gcd;
        demoninator = demoninator/gcd;
    }

    public void print(){
        if(demoninator==1){
            System.out.println(numerator);
        }
        else{
            System.out.println(numerator + "/" + demoninator);
        }
    }

    public void add(Fraction f2){
        this.numerator = (this.numerator*f2.demoninator) + (f2.numerator*this.demoninator);
        this.demoninator = this.demoninator*f2.demoninator;
        simplyfy();
    }

    public void multiply(Fraction f2){
        this.numerator*=f2.numerator;
        this.demoninator*=f2.demoninator;
        simplyfy();
    }

    public static Fraction add(Fraction f1, Fraction f2){
        int newNum = f1.numerator*f2.demoninator + f2.numerator*f1.demoninator;
        int newDen = f1.demoninator*f2.demoninator;
        Fraction f = new Fraction(newNum ,newDen);
        return f;
    }

    public static void main(String[] args) {
        Fraction f1 = new Fraction(20,30);
        f1.print();
        // 2/3

        f1.setNumerator(12);
        // 12/3 = 4/1
        int d = f1.getDemoninator();
        System.out.println(d); // 1
        f1.print(); // 4

        f1.setNumerator(10);
        int i = 47;
        try{
            i++;
            f1.setDemoninator(0);
            i++;
        }
        catch (ZeroDenominatorException e){
            System.out.println("Hey Dont set 0 as denominator");
        }
        System.out.println(i);
        f1.print(); // 1/3 ;

        Fraction f2 = new Fraction(3,4);
        f1.add(f2); // 1/3 + 3/4 => 13/12
        f1.print(); // 13/12

        f2.print(); //3/4

        Fraction f3 = new Fraction(4,5);
        f3.multiply(f2); // 4/5 * 3/4 => 12/20 => 3/5 (GCD = 4)
        f3.print(); //  3/5
        f2.print(); // 3/4

        Fraction f4 = Fraction.add(f1,f3);
        f4.print();
    }
}
