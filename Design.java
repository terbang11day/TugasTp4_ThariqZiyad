public class Design extends Division {

    public Design(int baseSalary) {
        super(baseSalary);
    }

    @Override
    public void addEmployee(Employee employee) {
        if (employee instanceof Employee || employee instanceof Manager) {
            super.addEmployee(employee);
            System.out.printf("Karyawan %s berhasil ditambahkan ke divisi Design.\n", employee.getName());
        } else {
            System.out.println("Hanya Karyawan atau Manager yang dapat ditambahkan ke divisi Design.");
        }
    }
}