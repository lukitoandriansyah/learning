package day00003.point01LoopControl;

public class WhileLoop {

    public static void main(String[] args) {
        int[] numbers = {10, 12, 56, 89};
        String[] names = {"Luki", "Ito", "Andri", "Ansyah"};
        int count = 0;
        while (count < numbers.length) {
            System.out.print(numbers[count]);
            System.out.print(",");
            count++;
        }
        count -= count;
        while (count < names.length) {
            System.out.print(names[count]);
            System.out.print(",");
            count++;
        }


    }
}
