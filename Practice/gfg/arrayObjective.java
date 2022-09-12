package Practice.gfg;

import java.util.Scanner;

class Students{
    String name;
    int roll_no;
    Students(String name , int roll_no){
        this.name = name;
        this.roll_no = roll_no;
    }
}
public class arrayObjective {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Students [] arr = new Students[5];
        for (int i = 1; i < arr.length; i++) {
            arr[i].name = sc.nextLine();
            arr[i].roll_no = sc.nextByte();
        }
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i].name + " " + arr[i].roll_no);
        }

    }
}
