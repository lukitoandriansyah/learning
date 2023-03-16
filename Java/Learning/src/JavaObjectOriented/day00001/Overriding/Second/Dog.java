package JavaObjectOriented.day00001.Overriding.Second;

public class Dog extends Animal{
    public void move(){
        System.out.println("Dogs can walk and run");
    }

    public void bark(){
        super.move();
        System.out.println("Dogs can bark");
    }
}
