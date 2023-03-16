package JavaObjectOriented.day00001.Polymorphism.VirtualMethods;

public class Demo{
    public static void main(String[] args) {
        Salary salary = new Salary("Lukito", "Anlaika", 1, 289.90);
        Employee employee = new Salary("Andri", "KILA", 4, 56.90);
        System.out.println("Call mail check using Salary refrences: ");
        salary.mailCheck();
        System.out.println("\n Call mailcheck using EMPLOYEE REFRENCES: ");
        employee.mailCheck();

    }
}
