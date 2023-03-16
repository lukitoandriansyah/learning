package BasicJava.day00003.point03Methods;

import java.util.Scanner;

public class VoidMethods {
    static Scanner input = new Scanner(System.in);
    public static double input(){
        return input.nextDouble();
    }

    public static void methodRankPoints(double points) {
        if (points >= 100.00) {
            System.out.println("Rank: A1");
        } else if (points>90.00) {
            System.out.println("Rank: A2");
        } else {
            System.out.println("Rank: A3");
        }
    }

    public static void main(String[] args) {
        System.out.print("Points :");
        methodRankPoints(input());
    }
}
