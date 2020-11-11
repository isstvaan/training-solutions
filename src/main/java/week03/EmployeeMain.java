package week03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeMain {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(new Position("CEO", 150_000)));

        for (Employee employee : employees) {
            if (employee.getPosition().getName().equalsIgnoreCase("CEO")) {

            }
        }
    }
}
