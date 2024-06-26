package emplye_management_system;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // Abstract method to be implemented by subclasses
    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee [name=" + name + ", id=" + id + ", salary=" + calculateSalary() + "]";
    }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

class PayrollSystem {
    private List<Employee> employeeList;

    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int id) {
        Employee employeeToRemove = null;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        }
    }

    public void displayEmployees() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }
}

public class Emplye_Management_System {

	public static void main(String[] args) {
		PayrollSystem payrollSystem = new PayrollSystem();
		System.out.println("Which type of emplyee you want to hired FullTimeEmployee or PartTimeEmployee ");
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter your choise press 1 for FullTimeEmployee Or press 2 for PartTimeEmployee");
		int choise=scanner.nextInt();
		
		System.out.println("Enter the name of employee ");
		String Name=scanner.nextLine();
		System.out.println("Enter The Id For Employee ");
		int EmID=scanner.nextInt();
		
		
		
		if(choise==1) {
		System.out.println("Enter The Salary For Employee");
		Double salaryDouble=scanner.nextDouble();
		FullTimeEmployee emp1 = new FullTimeEmployee(Name, EmID, salaryDouble);
		payrollSystem.addEmployee(emp1);
		}
        if(choise==2) {
        	System.out.println("Enter The Hourly Rate For Employee");
            int hourlyRate = scanner.nextInt();

            System.out.println("Enter The Hours Worked For Employee");
            int hoursWorked = scanner.nextInt();
           PartTimeEmployee emp2 = new PartTimeEmployee(Name, EmID, hourlyRate, hoursWorked);
           payrollSystem.addEmployee(emp2);

        }
        
  System.out.println("if you want to see employee detail so detais press 10 ");
  int choiseforDetails=scanner.nextInt();
  if(choiseforDetails==10) {
        System.out.println("Initial Employee Details:");
        payrollSystem.displayEmployees();
  }
  System.out.println("if you want to remove any employee so add id of emplyee");
  int idofEmployeeforremove=scanner.nextInt();
  if(idofEmployeeforremove==EmID) {
        System.out.println("\nRemoving Employee...");
        payrollSystem.removeEmployee(EmID);
  }
        System.out.println("\nRemaining Employee Details:");
        payrollSystem.displayEmployees();

	}

}
