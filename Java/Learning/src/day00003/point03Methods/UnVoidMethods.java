package day00003.point03Methods;

public class UnVoidMethods {
    public static int minFunction(int a, int b) {
        return Math.min(a, b);
    }

    public static void main(String[] args) {
        int a = 19;
        int b = 20;
        System.out.print("Min number is: " + minFunction(a, b));
    }
}
