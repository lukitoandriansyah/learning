package JavaObjectOriented.day00001.Overriding.Second;

public class Dog extends Animal{
    public void move(){
        super.move();
        System.out.println("Dogs can walk and run");
    }

    public void bark(){
        System.out.println("Dogs can bark");
    }
}
