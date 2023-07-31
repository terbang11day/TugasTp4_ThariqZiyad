import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private int yearsOfExperience;
    private double salaryMultiplier;
    private Division division;
    private List<Project> projects;

    public Employee(String name, int yearsOfExperience, double salaryMultiplier) {
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
        this.salaryMultiplier = salaryMultiplier;
        this.projects = new ArrayList<>();
    }

    public int calculateSalary() {
        int divisionBaseSalary = division.getBaseSalary();
        return (int) (divisionBaseSalary * (1 + salaryMultiplier + yearsOfExperience / 10.0));
    }

    public String getDivisionName() {
        return division.getClass().getSimpleName();
    }

    public String getProjectsString() {
        StringBuilder projectsString = new StringBuilder();
        for (Project project : projects) {
            projectsString.append(project.getName()).append(", ");
        }
        if (projectsString.length() > 2) {
            projectsString.setLength(projectsString.length() - 2);
        }
        return projectsString.toString();
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public String getName() {
        return name;
    }

    public Division getDivision() {
        return division;
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public void removeProject(Project project) {
        projects.remove(project);
    }
}
