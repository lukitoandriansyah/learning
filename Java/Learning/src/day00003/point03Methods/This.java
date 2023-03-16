package day00003.point03Methods;

public class This {
    int num = 10;

    This() {
        System.out.println("This is an example program on keyword this");
    }

    This(int num) {
        this();
        this.num = num;
    }

    public void greet() {
        System.out.println("Hi Welcome to Our Tutorial");
    }

    public void print() {
        int num = 20;

        System.out.println("value of local variable num is : "+num);

        System.out.println("value of instance variable num is : "+this.num);

        this.greet();
    }

    public static void main(String[] args) {
        This obj1 = new This();

        obj1.print();

        This obj2 = new This(30);

        obj2.print();
    }
}
