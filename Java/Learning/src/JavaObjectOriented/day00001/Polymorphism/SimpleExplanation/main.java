package JavaObjectOriented.day00001.Polymorphism.SimpleExplanation;

public class main {
    public static void main(String[] args) {
        Physics physics = new Physics();

        System.out.println(physics instanceof Book);
        System.out.println(physics instanceof Physics);
        System.out.println(physics instanceof Sciences);
        System.out.println(physics instanceof Object);
    }
}
