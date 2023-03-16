package BasicJava.day00004.innerClasses.nonStaticNestedClass.anonymusInnerClass.withoutArg;

public class OuterClass {
    public static void main(String[] args) {
        AnonymousInner anonymousInner = new AnonymousInner() {
            @Override
            public void myMethod() {
                System.out.println("This is an example of anonymous innerclass without arg");
            }
        };
        anonymousInner.myMethod();
    }
}
