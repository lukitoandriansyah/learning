package BasicJava.day00003.point01LoopControl;

public class ForLoop {
    public static void main(String[] args) {
        int[] numbers = {10, 12, 56, 89};
        for (int number : numbers) {
            System.out.print(number);
            System.out.print(",");
        }

        System.out.println("\n");
        String[] names = {"Luki", "Ito", "Andri", "Ansyah"};

        for (String name : names) {
            System.out.print(name);
            System.out.print(",");
        }

    }

}
