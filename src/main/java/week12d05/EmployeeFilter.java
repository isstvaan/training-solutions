package week12d05;

import java.util.ArrayList;
import java.util.List;

public class EmployeeFilter {
    public List<Employee> countSeniorDevs(List<Employee> employees) {
        List<Employee> retVal = new ArrayList<>();
        for (Employee item : employees) {
            if (item.getSkills().contains("programming") && item.getSkillLevel() > 2) {
                retVal.add(item);
            }
        }
        return retVal;
    }
}
