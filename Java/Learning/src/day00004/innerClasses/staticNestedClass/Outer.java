package day00004.innerClasses.staticNestedClass;

public class Outer {
    static class NestedDemo{
        public void myMethod(){
            System.out.println("This is my nested class");
        }
    }

    public static void main(String[] args) {
        Outer.NestedDemo nestedDemo = new Outer.NestedDemo();
        nestedDemo.myMethod();
    }
}
