package BasicJava.day00004.innerClasses.nonStaticNestedClass.innerClass;

public class MyClass {
    public static void main(String[] args) {
        OuterDemo outerDemo = new OuterDemo();
        outerDemo.displayInnerDemo();
        OuterDemo.InnerDemo2 innerDemo2 =outerDemo.new InnerDemo2();
        innerDemo2.getNum(12);



    }
}
