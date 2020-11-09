public class Employee {
    private String name;
    private String job;
    private int salary;

    public Employee(String name, String job, int salary) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name parameter is not valid!");
        }

        if (job == null || job.isEmpty()) {
            throw new IllegalArgumentException("job parameter is not valid!");
        }

        if (salary > 0 && salary % 1000 != 0) {
            throw new IllegalArgumentException("salary parameter is not valid!");
        }

        this.name = name;
        this.job = job;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " - " + job + " - " + salary + " Ft";
    }
}
