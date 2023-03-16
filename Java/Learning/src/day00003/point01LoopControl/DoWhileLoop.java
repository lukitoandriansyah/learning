package day00003.point01LoopControl;

public class DoWhileLoop {
    public static void main(String[] args) {
        int[] numbers = {10, 12, 56, 89};
        String[] names = {"Luki", "Ito", "Andri", "Ansyah"};
        int count = 0;

        do {
            System.out.print(numbers[count]);
            System.out.print(",");
            count++;
        } while (count < numbers.length);

        count -= count;
        do {
            System.out.print(names[count]);
            System.out.print(",");
            count++;
        } while (count < names.length);
    }
}
