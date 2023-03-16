package JavaObjectOriented.day00001.Inherritance.HasARelationship;

public class main {
    public static void main(String[] args) {
        Speed speed = new Speed();
        Van van = new Van(speed);
        System.out.println(van.color);
        van.setSpeed();
    }

}
