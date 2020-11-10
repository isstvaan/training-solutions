package debug;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Employee> employes;

    public Company(List<Employee> employee) {
        this.employes = employee;
    }

    public void addEmployee(Employee employe) {
        this.employes.add(employe);
    }

    public Employee findEmployeeByName(String employeeName) {
        for (int i = 0; i < employes.size(); i++) {
            if (employes.get(i).getName() == employeeName)
                return employes.get(i);
        }
        return null;
    }

    public List<String> listEmployeeNames() {
        List<String> names = new ArrayList<>();

        for (Employee item : employes) {
            names.add(item.getName());
        }
        return names;
    }
}
