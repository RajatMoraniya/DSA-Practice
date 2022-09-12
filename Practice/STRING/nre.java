package Practice.STRING;
import java.util.*;

public class nre {
    public static void time(float distance , float speed){
        double time =  distance/speed;
        int hour = (int) time;
        System.out.print(hour + " hour : ");
        int minute = (int)((time-hour)*60);
        System.out.print( minute + " minutes ");

    }
    public static float speed(float distance , float time){
        return distance/time;
    }
    public static float distance(float speed , float time){
        return speed*time;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What do you want to calculate : \n If time (Press 1) , speed (press 2) ,  distance (press 3 )");
        int decision = sc.nextInt();
        if(decision==1){
            System.out.print("Enter Distance in KM = ");
            float distance = sc.nextFloat();
            System.out.print("Enter Speed in KM/H: ");
            float sp = sc.nextFloat();
            time(distance,sp);

        }
        if(decision==2) {
            System.out.print("Enter time = ");
            System.out.print("hour : ");
            float hour = sc.nextFloat();
            System.out.print("minute : ");
            float minutes = sc.nextFloat();
            System.out.print("second : ");
            float second = sc.nextFloat();

            float time = hour + (minutes / 60) + (second / (60 * 60));

            System.out.print("Enter Distance in KM = ");
            float distance = sc.nextFloat();
            float speedd = speed(distance, time);
            System.out.format("Speed is %.2f km/h" , speedd) ;
        }
        if(decision==3){
            System.out.print("Enter Speed in KM/H: ");
            float ssp = sc.nextFloat();

            System.out.print("Enter time = ");
            System.out.print("hour : ");
            float hourr = sc.nextFloat();
            System.out.print("minute : ");
            float minutess = sc.nextFloat();
            System.out.print("second : ");
            float secondd = sc.nextFloat();

            float timee = hourr + (minutess / 60) + (secondd / (60 * 60));
            System.out.println(timee);

            System.out.print("Distance is "+ distance(ssp, timee) + " kilometers ");

        }





    }
}
