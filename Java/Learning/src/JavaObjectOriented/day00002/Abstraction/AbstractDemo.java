package JavaObjectOriented.day00002.Abstraction;

public class AbstractDemo {
    public static void main(String[] args) {
        Salary salary = new Salary("Ito", "Jakarta 12", 12, 200);
        Employee employee = new Salary("Oti", "Jakarta 89", 12, 15);
        System.out.println("Call mailCheck using Salary reference ---");
        salary.mailCheck();
        System.out.println("\n Call mailCheck using Employee reference to mailCheck");
        employee.mailCheck();
    }
}
