package day00002.point03VariableTypes.classicOrStaticVariables;

public class EmployeeTest {

    private  static  double salary;

    public static final String Dept = "Dev ";

    public static void main(String[] args) {
        salary =5000000;
        System.out.println(Dept + "Avg. Salary: "+ salary);
    }
}
