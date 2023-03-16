package day00003.point03Methods;

public class PassingParametersByValue {
    public static void swapFunction(int a, int b){
        System.out.println("Before swapping(Inside), a = " + a + " b = " + b);

        int x = a;
        a=b;
        b=x;

        System.out.println("After swapping(Inside), a = " + a + " b = " + b);

    }
    public static void main(String[] args) {
        int a = 78;
        int b=89;
        System.out.println("Before swapping, a = "+a+" and b = "+b);

        swapFunction(a, b);
        System.out.println("\n**Now, Before and After swapping values will be same here**:");
        System.out.println("After swapping, a = " + a + " and b is " + b);
    }
}
