import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimProyek {
    List<Project> projectList = new ArrayList<>();
    List<Employee> employeeList = new ArrayList<>();
    List<Division> divisionList = new ArrayList<>();

    public static void main(String[] args) {
        SimProyek app = new SimProyek();
        app.mockDivisionData();

        // Gunakan ini jika ingin menggunakan data awalan
        // Tidak wajib digunakan
        app.mockData();

        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("Selamat datang di SimProyek. Berikut adalah daftar proyek yang terdaftar dalam sistem.");

        // TODO: Tampilkan daftar proyek, lengkapi kode di dalam method printProjectList()
        app.printProjectList();

        do {
            app.printMenu();

            choice = scanner.nextInt();
            scanner.nextLine();

            int nomorPilihan;
            int nomorAnggota;
            String namaKaryawan;
            String jabatan;
            int lamaBekerja;
            double bonusGaji;
            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama proyek: ");
                    String projectName = scanner.nextLine();

                    // TODO: Kerjakan di dalam method ini
                    app.createProject(projectName);

                    System.out.println();
                    break;
                case 2:
                    System.out.println("Berikut adalah daftar proyek yang dapat Anda pilih: ");
                    app.printProjectListNumberOnly();

                    System.out.print("Pilih nomor proyek: ");
                    nomorPilihan = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Masukkan nama karyawan yang ingin ditambahkan: ");
                    namaKaryawan = scanner.nextLine();

                    // TODO: Kerjakan di dalam method ini
                    app.addProjectMember(nomorPilihan, namaKaryawan);

                    System.out.println();
                    break;
                case 3:
                    System.out.println("Berikut adalah daftar proyek yang dapat Anda pilih: ");
                    app.printProjectListNumberOnly();

                    System.out.print("Pilih nomor proyek: ");
                    nomorPilihan = scanner.nextInt();
                    scanner.nextLine();

                    app.printProjectDetail(nomorPilihan);

                    System.out.print("Masukkan nomor anggota yang ingin dihapus: ");
                    nomorAnggota = scanner.nextInt();
                    scanner.nextLine();

                    // TODO: Kerjakan di dalam method ini
                    app.deleteProjectMember(nomorPilihan, nomorAnggota);

                    System.out.println();
                    break;
                case 4:
                    System.out.println("Berikut adalah daftar proyek yang dapat Anda pilih: ");
                    app.printProjectListNumberOnly();

                    System.out.print("Pilih nomor proyek: ");
                    nomorPilihan = scanner.nextInt();
                    scanner.nextLine();

                    // TODO: Kerjakan di dalam method ini
                    app.printProjectDetail(nomorPilihan);

                    System.out.println();
                    break;
                case 5:
                    System.out.println("Daftar proyek pada sistem SimProyek");
                    app.printProjectList();

                    System.out.println();
                    break;
                case 6:
                    System.out.print("Nama karyawan: ");
                    namaKaryawan = scanner.nextLine();

                    System.out.print("Jabatan: ");
                    jabatan = scanner.nextLine();

                    System.out.print("Lama bekerja (tahun): ");
                    lamaBekerja = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Bonus gaji: ");
                    bonusGaji = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Divisi:");
                    System.out.println("1. HRD");
                    System.out.println("2. Marketing");
                    System.out.println("3. Design");
                    System.out.println("4. Engineer");

                    System.out.print("Pilih divisi: ");
                    nomorPilihan = scanner.nextInt();
                    scanner.nextLine();

                    // TODO: Kerjakan di dalam method ini
                    app.addEmployee(namaKaryawan, jabatan, lamaBekerja, bonusGaji, nomorPilihan);

                    System.out.println();
                    break;
                case 7:
                    System.out.println("Daftar karyawan pada sistem SimProyek ");
                    System.out.println("Nama - Divisi - Gaji - Proyek ");
                    for (int i = 0; i < app.employeeList.size(); i++) {
                        System.out.printf("%d. %s - Divisi %s - %d - %s \n",
                                i + 1,
                                // TODO: lengkapi logika di masing-masing method
                                app.employeeList.get(i).getName(),
                                app.employeeList.get(i).getDivisionName(),
                                app.employeeList.get(i).calculateSalary(),
                                app.employeeList.get(i).getProjectsString()
                        );
                    }

                    System.out.println();
                    break;
                case 8:
                    System.out.println("Berikut adalah daftar divisi pada sistem SimProyek: ");
                    System.out.println("1. HRD");
                    System.out.println("2. Marketing");
                    System.out.println("3. Design");
                    System.out.println("4. Engineer");


                    System.out.print("Pilih nomor divisi: ");
                    nomorPilihan = scanner.nextInt();
                    scanner.nextLine();

                    // TODO: tampilkan detail divisi
                    app.printDivisionDetail(nomorPilihan);

                    System.out.println();
                    break;
                case 99:
                    System.out.println("Terima kasih telah menggunakan SimProyek.");
                    break;
                default:
                    System.out.println("Pilihan menu tidak valid.");
                    break;
            }
        } while (choice != 99);
        scanner.close();
    }

    // Silahkan tambahkan method lain yang dirasa dapat membantu

    private void printProjectListNumberOnly() {
        int number = 1;
        for (Project project : projectList) {
            System.out.printf("%d. %s\n", number++, project.getName());
        }
    }

    private void printDivisionDetail(int nomorPilihan) {
        Division division = divisionList.get(nomorPilihan - 1);
        System.out.printf("Divisi %s memiliki %d karyawan dengan %d manager.\n",
                division.getClass().getSimpleName(),
                division.getEmployeeList().size(),
                division.getManagersCount());
    
        List<Employee> employees = division.getEmployeeList();
        int number = 1;
        for (Employee employee : employees) {
            System.out.printf("%d. %s - Divisi %s\n",
                    number++,
                    employee.getName(),
                    employee.getDivisionName());
        }
    }
    
    

    private void addEmployee(String namaKaryawan, String jabatan, int lamaBekerja, double bonusGaji, int nomorDivisi) {
        Division division = divisionList.get(nomorDivisi - 1);
        Employee employee;
        if (jabatan.equalsIgnoreCase("manager")) {
            employee = new Manager(namaKaryawan, lamaBekerja, bonusGaji);
        } else if (jabatan.equalsIgnoreCase("employee")) {
            employee = new Employee(namaKaryawan, lamaBekerja, bonusGaji);
        } else {
            System.out.println("Jabatan tidak valid.");
            return;
        }
        division.addEmployee(employee);
        employee.setDivision(division); // Tambahkan baris ini untuk menetapkan divisi karyawan
        employeeList.add(employee);
        System.out.printf("Karyawan %s berhasil ditambahkan ke divisi %s.\n",
                namaKaryawan, division.getClass().getSimpleName());
    }
    
    

    private void printProjectList() {
        int number = 1;
        for (Project project : projectList) {
            System.out.printf("%d. %s\n", number++, project);
        }
    }

    private void printProjectDetail(int nomorPilihan) {
        Project project = projectList.get(nomorPilihan - 1);
        System.out.printf("Proyek %s Detail:\n", project.getName());
    
        Manager projectLeader = project.getProjectLeader();
        System.out.printf("Leader: %s\n", (projectLeader != null) ? projectLeader.getName() : "Tidak memiliki leader");
    
        List<Employee> members = project.getMemberList();
        if (members.isEmpty()) {
            System.out.println("Anggota: Tidak memiliki anggota");
        } else {
            int number = 1;
            System.out.println("Anggota:");
            for (Employee member : members) {
                Division division = member.getDivision();
                String divisionName = (division != null) ? division.getClass().getSimpleName() : "Tidak diketahui";
                System.out.printf("%d. %s - Divisi %s\n", number++, member.getName(), divisionName);
            }
        }
    }
    
    
    private void deleteProjectMember(int nomorPilihan, int nomorAnggota) {
        Project project = projectList.get(nomorPilihan - 1);
        List<Employee> members = project.getMemberList();
        if (members.isEmpty()) {
            System.out.println("Gagal: Proyek " + project.getName() + " sudah tidak memiliki anggota.");
        } else if (nomorAnggota <= 0 || nomorAnggota > members.size()) {
            System.out.println("Gagal: Angka yang dimasukkan tidak valid.");
        } else {
            Employee employee = members.get(nomorAnggota - 1);
            project.removeMember(employee);
            System.out.println("Anggota " + employee.getName() + " berhasil dihapus dari " + project.getName() + ".");
        }
    }
    
    

    private void addProjectMember(int nomorPilihan, String namaKaryawan) {
        if (nomorPilihan < 1 || nomorPilihan > projectList.size()) {
            System.out.println("Input invalid. Kembali ke menu utama.");
            return;
        }
    
        Project project = projectList.get(nomorPilihan - 1);
        
        // Check if the employee is already a member of the project
        for (Employee member : project.getMemberList()) {
            if (member.getName().equalsIgnoreCase(namaKaryawan)) {
                System.out.printf("Karyawan %s sudah menjadi anggota dari %s.\n", namaKaryawan, project.getName());
                return;
            }
        }
    
        // If the employee is not a member of the project, proceed to add them
        for (Employee employee : employeeList) {
            if (employee.getName().equalsIgnoreCase(namaKaryawan)) {
                project.addMember(employee);
                System.out.printf("Karyawan %s berhasil ditambahkan ke %s.\n", namaKaryawan, project.getName());
                return;
            }
        }
        
        System.out.println("Karyawan tidak ditemukan.");
    }
    
    

    private void createProject(String projectName) {
        for (Project project : projectList) {
            if (project.getName().equalsIgnoreCase(projectName)) {
                System.out.println("Proyek dengan nama yang sama sudah ada. Masukkan nama proyek yang berbeda.");
                return;
            }
        }
        
        Project project = new Project(projectName);
        projectList.add(project);
        System.out.printf("Proyek %s berhasil ditambahkan ke dalam sistem.\n", projectName);
    }
    

    private void printMenu() {
        System.out.println("Menu:");
        System.out.println("1. Tambah proyek");
        System.out.println("2. Tambah anggota proyek");
        System.out.println("3. Hapus anggota proyek");
        System.out.println("4. Detail proyek");
        System.out.println("5. Daftar proyek");
        System.out.println("6. Tambah karyawan");
        System.out.println("7. Daftar karyawan");
        System.out.println("8. Detail divisi");
        System.out.println("99. Keluar");
        System.out.print("Pilih menu: ");
    }

private void mockDivisionData() {
        Division hrd = new HRD(5000000);
        Division marketing = new Marketing(7000000);
        Division design = new Design(6000000);
        Division engineering = new Engineering(8000000);

        divisionList.add(hrd);
        divisionList.add(marketing);
        divisionList.add(design);
        divisionList.add(engineering);
    }

    private void mockData() {
        Division hrd = this.divisionList.get(0);
        Division marketing = this.divisionList.get(1);
        Division design = this.divisionList.get(2);

        Manager budi = new Manager("Budi", 3, 0.2);
        Manager ica = new Manager("Ica", 5, 0.3);
        Manager andi = new Manager("Andi", 4, 0.25);

        Employee udin = new Employee("Udin", 2, 0.1);
        Employee fira = new Employee("Fira", 1, 0.05);
        Employee opet = new Employee("Opet", 3, 0.15);
        Employee mirna = new Employee("Mirna", 4, 0.2);
        Employee asep = new Employee("Asep", 2, 0.1);
        Employee yudi = new Employee("Yudi", 1, 0.05);
        Employee deni = new Employee("Deni", 3, 0.15);
        Employee tina = new Employee("Tina", 2, 0.1);

        this.employeeList.add(budi);
        this.employeeList.add(ica);
        this.employeeList.add(andi);
        this.employeeList.add(udin);
        this.employeeList.add(fira);
        this.employeeList.add(opet);
        this.employeeList.add(mirna);
        this.employeeList.add(asep);
        this.employeeList.add(yudi);
        this.employeeList.add(deni);
        this.employeeList.add(tina);
        
        hrd.addEmployee(budi);
        hrd.addEmployee(udin);
        hrd.addEmployee(fira);
        hrd.addEmployee(opet);

        marketing.addEmployee(ica);
        marketing.addEmployee(mirna);
        marketing.addEmployee(asep);
        marketing.addEmployee(yudi);

        design.addEmployee(andi);
        design.addEmployee(deni);
        design.addEmployee(tina);

        Project ufoProject = new Project("Proyek UFO");
        Project saladProject = new Project("Proyek Franchise Salad Buah Tanpa Semangka dan Melon");
        Project compfestProject = new Project("Website COMPFEST");

        ufoProject.addMember(budi);
        ufoProject.addMember(udin);
        ufoProject.addMember(fira);
        ufoProject.addMember(opet);

        saladProject.addMember(ica);
        saladProject.addMember(mirna);
        saladProject.addMember(asep);
        saladProject.addMember(yudi);

        compfestProject.addMember(andi);
        compfestProject.addMember(deni);
        compfestProject.addMember(tina);

        this.projectList.add(ufoProject);
        this.projectList.add(saladProject);
        this.projectList.add(compfestProject);
    }
}


