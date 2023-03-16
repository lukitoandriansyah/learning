package JavaObjectOriented.day00001.Inherritance.superKeyword;

public class SubClass extends SuperClass{
    int num = 45;
     public void display(){
         System.out.println("This called fro sub-class");
     }

     public void myMethod(){
         SubClass subClass = new SubClass();

         subClass.display();
         super.display();

         System.out.println("variable num in subclass: " + subClass.num);
         System.out.println("variable num in superclass: " + super.num);


     }
}
