package day00004.innerClasses.nonStaticNestedClass.methodLocalInnerClass;

public class OuterClass {
    void method(){
        int num = 12;
        class MethodInnerDemo{
            public void print(){
                System.out.println("This is an example of inner class\n"+num);
            }
        }
        MethodInnerDemo methodInnerDemo = new MethodInnerDemo();
        methodInnerDemo.print();
    }
}
