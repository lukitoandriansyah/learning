package JavaObjectOriented.day00001.Overriding.Second;

public class main {
    public static void main(String[] args) {
        Animal animal1 = new Dog();
        animal1.move();
        ((Dog) animal1).bark();
    }
}
