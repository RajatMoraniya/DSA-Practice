package OOPS;

public class ComplexNumber {
    private int real;
    private int imaginary;

    public ComplexNumber(int real ,int imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    public int getImaginary(){
        return this.imaginary;
    }
    public int getReal(){
        return this.real;
    }

    public void setReal(int r){
        this.real = r;
    }
    public void setImaginary(int i){
        this.imaginary = i;
    }

    public void print(){
        if(real==0){
            System.out.println(this.imaginary + "i");
        }
        else{
        System.out.println(this.real + "+i"+ this.imaginary );
        }
    }

    public void add(ComplexNumber c2){
        this.real += c2.real;
        this.imaginary += c2.imaginary;
    }

    public void multiply(ComplexNumber c2){
        this.real = this.real*c2.real-this.imaginary*c2.imaginary;
        this.imaginary = (this.real*c2.imaginary) + (c2.real*this.imaginary);
    }

    public ComplexNumber conjugate(){
        int r = this.real;
        int i = this.imaginary;
        ComplexNumber c = new ComplexNumber(r,-i);
        return c;
    }

    public static ComplexNumber add(ComplexNumber c1,ComplexNumber c3){
        int r = c1.real + c3.real;
        int i = c1.imaginary + c3.imaginary;
        ComplexNumber c = new ComplexNumber(r,i);
        return c;
    }

    public static void main(String[] args) {
        ComplexNumber c1 = new ComplexNumber(2,3);
        c1.print();

        c1.setReal(10);
        c1.setImaginary(30);
        c1.print();

        ComplexNumber c2 = new ComplexNumber(1,5);
        c1.add(c2);
        c1.print();
        c2.print();

        ComplexNumber c3 = new ComplexNumber(3,2);
        c3.multiply(c2);
        c3.print();
        c2.print();

        ComplexNumber c4 = ComplexNumber.add(c1,c3);
        c1.print();
        c3.print();
        c4.print();

        ComplexNumber c5 = c1.conjugate();
        c5.print();
    }

}
