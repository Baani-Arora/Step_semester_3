package oop.assignment_problems;

class EmployeeStatic {

    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    EmployeeStatic(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        new EmployeeStatic("A", 10000);
        new EmployeeStatic("B", 20000);
        new EmployeeStatic("C", 30000);

        EmployeeStatic.printCompanyInfo();
    }
}