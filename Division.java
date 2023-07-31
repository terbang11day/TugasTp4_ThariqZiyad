import java.util.ArrayList;
import java.util.List;

public class Division {
    private int baseSalary;
    private List<Employee> employeeList;

    public Division(int baseSalary) {
        this.baseSalary = baseSalary;
        this.employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public int getManagersCount() {
        int count = 0;
        for (Employee employee : employeeList) {
            if (employee instanceof Manager) {
                count++;
            }
        }
        return count;
    }
}
