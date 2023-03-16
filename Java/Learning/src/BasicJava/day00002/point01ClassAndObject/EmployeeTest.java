package BasicJava.day00002.point01ClassAndObject;

public class EmployeeTest {
    public static void main(String[] args) {
        System.out.println("==============================\n");
        Employee employee1 = new Employee("Lukito");
        Employee employee2 = new Employee("Andriansyah");

        employee1.empAge(24);
        employee1.empDesignation("BE Developer");
        employee1.empSalary(5000000);
        employee1.printEmployee();

        employee2.empAge(24);
        employee2.empDesignation("Song Creator");
        employee2.empSalary(8000000);
        employee2.printEmployee();
    }
}
