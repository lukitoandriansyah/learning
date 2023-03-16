package JavaObjectOriented.day00001.Inherritance.extendsKeyword;

public class MyCalculation extends Calculation {
    public void multiplication(int x, int y){
        z = x *y;
        System.out.println("The product of multiplecation is: "+z);
    }

    public static void main(String[] args) {
        int a = 89;
        int b = 3;
        MyCalculation myCalculation = new MyCalculation();
        myCalculation.addition(a, b);
        myCalculation.subtraction(a, b);
        myCalculation.multiplication(a, b);
    }
}
