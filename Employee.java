import java.util.List;

public class Employee {
    // TODO: Tambahkan modifier untuk atribut
    String name;
    int yearsOfExperience;
    double salaryMultiplier;
    Division division;
    List<Project> projects;

    // TODO: Lengkapi constructor
    public Employee(String name, int yearsOfExperience, double salaryMultiplier) {
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
        this.salaryMultiplier = salaryMultiplier;
    }

    public int calculateSalary() {
        // TODO Lengkapi logika untuk menghitung gaji
        int divisionBaseSalary = division.baseSalary;
        return (int) (divisionBaseSalary * (1 + salaryMultiplier + yearsOfExperience / 10));
    }

    public String getDivisionName() {
        //TODO: Lengkapi logika untuk mendapat string nama divisi
        return division.getClass().getSimpleName();
    }

    public String getProjectsString() {
        //TODO: Lengkapi logika untuk mendapat string daftar proyek
        StringBuilder sb = new StringBuilder();
        for (Project project : projects) {
            sb.append(project.name).append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }

    public String getName() {
        return name;
    }

    // Tambahkan getter & setter lainnya sesuai kebutuhan
}
