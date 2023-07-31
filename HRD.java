public class HRD extends Division {

    public HRD(int baseSalary) {
        super(baseSalary);
    }

    @Override
    public void addEmployee(Employee employee) {
        // Check if the employee is a Manager
        if (employee instanceof Manager) {
            super.addEmployee(employee);
            System.out.println("Karyawan " + employee.getName() + " berhasil ditambahkan ke divisi HRD.");
        } else {
            System.out.println("Gagal: Karyawan yang ditambahkan ke divisi HRD harus berjabatan Manager.");
        }
    }
}
