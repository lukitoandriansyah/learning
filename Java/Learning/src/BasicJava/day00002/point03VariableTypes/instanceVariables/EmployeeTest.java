package BasicJava.day00002.point03VariableTypes.instanceVariables;

public class EmployeeTest {
    public String name;
    private  double salary;
    public EmployeeTest(String empName){
        name = empName;
    }

    public void empSalary(double empSalary){
        salary = empSalary;
    }

    public void  printEmp(){
        System.out.println("name    : "+ name);
        System.out.println("salary  : "+ salary);
    }

    public static void main(String[] args) {
        EmployeeTest employeeTest1 = new EmployeeTest("Lukito");
        employeeTest1.empSalary(5000000);
        employeeTest1.printEmp();

    }
}
