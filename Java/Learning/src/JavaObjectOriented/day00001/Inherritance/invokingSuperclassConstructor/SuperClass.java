package JavaObjectOriented.day00001.Inherritance.invokingSuperclassConstructor;

public class SuperClass {
    int age;

    SuperClass(int age){
        this.age = age;
    }

    public void getAge(){
        System.out.println("This age: "+age);
    }
}
