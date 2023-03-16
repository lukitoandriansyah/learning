package JavaObjectOriented.day00001.Inherritance.HasARelationship;

public class Van extends Vehicle{
    private final Speed sp;

    public Van(Speed speed) {
        this.sp = speed;
    }

    void setSpeed(){
        System.out.println(sp.speed);
    }
}
