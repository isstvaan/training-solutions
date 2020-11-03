public class EmployeeMain {
    public static void main(String[] args) {
        Employee employee = new Employee("Béla",2000,1234567);

        System.out.println(employee.toString());

        employee.raiseSalary(12345);

        System.out.println(employee.toString());

    }
}
