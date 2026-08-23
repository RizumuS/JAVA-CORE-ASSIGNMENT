import java.util.*;

class Department {

    private String deptName, hodName;
    private List<Professor> professors;

    // Default constructor
    public Department() {
        professors = new ArrayList<>();
    }

    // Parameterized constructor
    public Department(String deptName, String hodName) {
        this.deptName = deptName;
        this.hodName = hodName;
        professors = new ArrayList<>();
    }

    // Getters
    public String getDeptName() {
        return deptName;
    }

    public String getHodName() {
        return hodName;
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    // Setters
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setHodName(String hodName) {
        this.hodName = hodName;
    }

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }

    // Add Professor
    public void addProfessor(Professor p) {
        professors.add(p);
    }

    // toString()
    @Override
    public String toString() {

        String result = "Department: " + deptName +
                        "  HOD: " + hodName +
                        "  Professors: ";

        for (Professor p : professors) {
            result = result + "  " + p;
        }

        return result;
    }
}

class Professor {

    private String name;
    private String employeeId;
    private String specialization;

    // Default constructor
    public Professor() {
    }

    // Parameterized constructor
    public Professor(String name, String employeeId, String specialization) {
        this.name = name;
        this.employeeId = employeeId;
        this.specialization = specialization;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getSpecialization() {
        return specialization;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    // toString()
    @Override
    public String toString() {
        return "Name: " + name +
               ", ID: " + employeeId +
               ", Specialization: " + specialization;
    }
}

public class Q1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Department details
        System.out.println("Enter Department details (deptName,hodName)");

        String departmentInput = sc.nextLine();

        int comma = departmentInput.indexOf(",");

        String deptName = departmentInput.substring(0, comma);
        String hodName = departmentInput.substring(comma + 1);

        // Create Department object
        Department department = new Department(deptName, hodName);

        // Number of professors
        System.out.println("Enter number of professors");

        int n = Integer.parseInt(sc.nextLine());

        // Professor details
        System.out.println("Enter professor details (name,employeeId,specialization)");

        for (int i = 0; i < n; i++) {

            String professorInput = sc.nextLine();

            int firstComma = professorInput.indexOf(",");
            int secondComma = professorInput.indexOf(",", firstComma + 1);

            String name = professorInput.substring(0, firstComma);

            String employeeId =
                    professorInput.substring(firstComma + 1, secondComma);

            String specialization =
                    professorInput.substring(secondComma + 1);

            // Create Professor object
            Professor professor =
                    new Professor(name, employeeId, specialization);

            // Add professor to department
            department.addProfessor(professor);
        }

        // Display department details
        System.out.println(department);

        sc.close();
    }
}