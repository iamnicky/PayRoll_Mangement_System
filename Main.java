import java.util.ArrayList;

abstract class Employee {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class FullTimeEmp extends Employee {
    private double monthlySalary;

    public FullTimeEmp(int id, String name, double monthlySalary) {
        super(id, name);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(int id, String name, double hourlyRate, int hoursWorked) {
        super(id, name);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return 0;
    }
}

class PayRollSystem {
    private ArrayList<Employee> employeeList;

    public PayRollSystem() {
        this.employeeList =new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int id) {
        Employee employeeToRemove = null;
        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                employeeToRemove = emp;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }
    }
    public void displayEmployees() {
        for (Employee employees : employeeList) {
            System.out.println("Employees: " + employees);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PayRollSystem payRollSystem = new PayRollSystem();
        FullTimeEmp emp1 = new FullTimeEmp(1, "nicky", 200);
        PartTimeEmployee emp2 = new PartTimeEmployee(2, "Das", 300, 4);
        payRollSystem.addEmployee(emp1);
        payRollSystem.addEmployee(emp2);
        System.out.println("Initial Employee details :");
        payRollSystem.displayEmployees();
        System.out.println("Removing Employee :");
        payRollSystem.removeEmployee(2);
        System.out.println("Remaining Employee Details");
        payRollSystem.displayEmployees();
    }
}
