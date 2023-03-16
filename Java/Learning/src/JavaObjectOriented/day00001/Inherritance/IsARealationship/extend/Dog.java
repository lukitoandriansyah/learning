package JavaObjectOriented.day00001.Inherritance.IsARealationship.extend;

public class Dog extends Mammal{
    public static void main(String[] args) {
        Animal animal= new Animal();
        Mammal mammal = new Mammal();
        Dog dog = new Dog();

        System.out.println(mammal instanceof Animal);
        System.out.println(dog instanceof Mammal);
        System.out.println(dog instanceof Animal);
    }
}
