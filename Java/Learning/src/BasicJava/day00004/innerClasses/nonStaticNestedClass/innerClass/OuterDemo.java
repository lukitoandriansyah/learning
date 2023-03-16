package BasicJava.day00004.innerClasses.nonStaticNestedClass.innerClass;

public class OuterDemo {
    int num;

    private class InnerDemo {
        public void print() {
            System.out.println("This is an example of Inner Class");
        }
    }

    protected class InnerDemo2{
        public void getNum(int num) {
            OuterDemo outerDemo = new OuterDemo();
            outerDemo.num = num;
            System.out.println(outerDemo.num);
        }
    }

    void displayInnerDemo() {
        InnerDemo innerDemo = new InnerDemo();
        innerDemo.print();
    }
}
