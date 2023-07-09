package JavaApplication;


		import java.util.ArrayList;
		import java.util.InputMismatchException;
		import java.util.List;
		import java.util.Scanner;

		public class infotrixs {
		    private List<Employee> employees;
		    private Scanner scanner;

		    public infotrixs() {
		        employees = new ArrayList<>();
		        scanner = new Scanner(System.in);
		    }

		    public static void main(String[] args) {
		    	infotrixs system = new infotrixs();
		        system.run();
		    }

		    public void run() {
		        boolean running = true;
		        while (running) {
		            System.out.println("\n * Employee Management System");
		            
		            System.out.println("1) Add Employee Details");
		            System.out.println("2) View Employees Details");
		            System.out.println("3) Update Employee Details");
		            System.out.println("4) Exit (Stop)");
		            System.out.print("Enter your choice (Between 1-4): ");
		            System.out.println(" ");
		            int choice = getUserChoice();
		            switch (choice) {
		                case 1:
		                    addEmployee();
		                    break;
		                case 2:
		                    viewEmployees();
		                    break;
		                case 3:
		                    updateEmployee();
		                    break;
		                case 4:
		                    running = false;
		                    break;
		                default:
		                    System.out.println("Invalid choice. Please try again.");
		            }
		        }
		        scanner.close();
		    }

		    private int getUserChoice() {
		        try {
		            return scanner.nextInt();
		        } catch (InputMismatchException e) {
		            scanner.next(); // clear the invalid input
		            return -1;
		        }
		    }

		    private void addEmployee() {
		        System.out.println(" * Add Employee Details");
		        System.out.print("Enter employee ID: ");
		        int id = getUserChoice();
		        scanner.nextLine(); // clear the newline character

		        System.out.print("Enter employee name: ");
		        String name = scanner.nextLine();

		        System.out.print("Enter employee designation: ");
		        String designation = scanner.nextLine();

		        Employee employee = new Employee(id, name, designation);
		        employees.add(employee);

		        System.out.println("Employee added successfully.");
		    }

		    private void viewEmployees() {
		        System.out.println("* Employee List");
		        if (employees.isEmpty()) {
		            System.out.println("No employees found.");
		        } else {
		            for (Employee employee : employees) {
		                System.out.println(employee);
		            }
		        }
		    }

		    private void updateEmployee() {
		        System.out.println("\n Update Employee");
		        System.out.print("Enter employee ID to update: ");
		        int id = getUserChoice();
		        scanner.nextLine(); // clear the newline character

		        Employee employee = findEmployeeById(id);
		        if (employee == null) {
		            System.out.println("Employee not found.");
		        } else {
		            System.out.print("Enter new name : ");
		            String newName = scanner.nextLine();
		            if (!newName.isEmpty()) {
		                employee.setName(newName);
		            }

		            System.out.print("Enter new designation : ");
		            String newDesignation = scanner.nextLine();
		            if (!newDesignation.isEmpty()) {
		                employee.setDesignation(newDesignation);
		            }

		            System.out.println("Employee updated successfully.");
		        }
		    }

		    private Employee findEmployeeById(int id) {
		        for (Employee employee : employees) {
		            if (employee.getId() == id) {
		                return employee;
		            }
		        }
		        return null;
		    }
		}

		class Employee {
		    private int id;
		    private String name;
		    private String designation;

		    public Employee(int id, String name, String designation) {
		        this.id = id;
		        this.name = name;
		        this.designation = designation;
		    }

		    public int getId() {
		        return id;
		    }

		    public String getName() {
		        return name;
		    }

		    public void setName(String name) {
		        this.name = name;
		    }

		    public String getDesignation() {
		        return designation;
		    }

		    public void setDesignation(String designation) {
		        this.designation = designation;
		    }

		    @Override
		    public String toString() {
		        return "ID: " + id + ", Name: " + name + ", Designation: " + designation;
		    }
		

	}


