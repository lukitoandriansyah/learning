package BasicJava.day00002.point02Constructor.parameterizedConstructor;

public class MyClassTest {
    public static void main(String[] args) {
        MyClass myClass1 = new MyClass(10);
        MyClass myClass2 = new MyClass(20);
        System.out.println(myClass1.x+ " " + myClass2.x);
    }
}
