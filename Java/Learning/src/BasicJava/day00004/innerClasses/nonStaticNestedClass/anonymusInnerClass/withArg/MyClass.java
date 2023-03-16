package BasicJava.day00004.innerClasses.nonStaticNestedClass.anonymusInnerClass.withArg;

public class MyClass {
    public void displayMessage(Message m){
        System.out.println(m.greet()+", This is an example of anonymous innerclass with arg");
    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass();

        myClass.displayMessage(() -> "Yoo");
    }
}
