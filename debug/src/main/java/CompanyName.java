import java.util.ArrayList;

public class CompanyName {
    public static void main(String[] args) {
        Company company = new Company(new ArrayList<>());

        company.addEmployee(new Employee("Sanyi",10));
        company.addEmployee(new Employee("Sanyi 2" ,15));
        company.addEmployee(new Employee("Sanyi 3",20));

        System.out.println("Béla nevű alakalmazott:"+ company.findEmployeeByName("Béla"));
        System.out.println("Sanyi nevű alakalmazott:"+ company.findEmployeeByName("Sanyi").getName());
        System.out.println("Alakalmazottak:"+ company.listEmployeeNames());
    }
}
