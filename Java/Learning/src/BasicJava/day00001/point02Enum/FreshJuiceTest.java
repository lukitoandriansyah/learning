package BasicJava.day00001.point02Enum;

public class FreshJuiceTest {
    public static void main(String[] args) {

        FreshJuice freshJuice = new FreshJuice();
        freshJuice.freshJuiceSize= FreshJuice.FreshJuiceSize.MEDIUM;
        System.out.println("Size: "+ freshJuice.freshJuiceSize);
    }
}
