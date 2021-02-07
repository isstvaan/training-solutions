package week14d04;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeTransformOperations {
    public List<Employee> transformToUpperCased(List<Employee> employees) {
        return employees.stream().map(o -> new Employee(o.getName().toUpperCase())).collect(Collectors.toList());
//        return employees.stream().map(employee -> employee.getName().toUpperCase()).collect(Collectors.toList());
//        List<Employee> retVal = new ArrayList<>();
//        for (Employee item : employees) {
//            retVal.add(new Employee(item.getName().toUpperCase()));
//        }
//        return retVal;
    }
}
