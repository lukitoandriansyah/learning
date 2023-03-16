package BasicJava.day00003.point03Methods;

public class Overloading {

    public static double MinFunction(double a, double b) {
        return Math.min(a, b);
    }

    public static int MinFunction(int a, int b) {
        return Math.min(a, b);
    }

    public static void main(String[] args) {
        System.out.println("Min Value Type Double is : " + MinFunction(20.89, 89));
        System.out.println("Min Value Type Integer is : " + MinFunction(9, 90));
    }

}
