import java.util.ArrayList;
import java.util.List;

/**
 * Representasi sebuah proyek dengan nama, pemimpin proyek, dan daftar anggota proyek.
 */
public class Project {
    private String name;
    private Manager projectLeader;
    private List<Employee> memberList;

    /**
     * Membuat instansi Proyek baru dengan nama yang diberikan.
     *
     * @param name Nama dari proyek.
     */
    public Project(String name) {
        this.name = name;
        this.memberList = new ArrayList<>();
    }

    /**
     * Menambahkan anggota ke proyek dan menghubungkan proyek dengan karyawan tersebut.
     *
     * @param employee Karyawan yang akan ditambahkan ke proyek.
     */
    public void addMember(Employee employee) {
        memberList.add(employee);
        employee.addProject(this);
    }

    /**
     * Menghapus anggota dari proyek dan memutuskan hubungan proyek dengan karyawan tersebut.
     *
     * @param employee Karyawan yang akan dihapus dari proyek.
     */
    public void removeMember(Employee employee) {
        memberList.remove(employee);
        employee.removeProject(this);
    }

    /**
     * Mendapatkan nama proyek.
     *
     * @return Nama proyek.
     */
    public String getName() {
        return name;
    }

    /**
     * Mendapatkan pemimpin proyek.
     *
     * @return Pemimpin proyek (seorang Manajer) atau null jika belum ada pemimpin yang ditetapkan.
     */
    public Manager getProjectLeader() {
        return projectLeader;
    }

    /**
     * Menetapkan pemimpin proyek dan menghubungkan proyek dengan manajer tersebut.
     *
     * @param projectLeader Manajer yang akan memimpin proyek.
     */
    public void setProjectLeader(Manager projectLeader) {
        this.projectLeader = projectLeader;
        projectLeader.addProject(this);
    }

    /**
     * Mendapatkan daftar anggota proyek.
     *
     * @return Sebuah List dari objek Karyawan yang mewakili anggota proyek.
     */
    public List<Employee> getMemberList() {
        return memberList;
    }

    /**
     * Mengembalikan representasi string dari proyek, termasuk nama, pemimpin, dan jumlah anggota.
     *
     * @return Representasi string dari proyek.
     */
    @Override
    public String toString() {
        return String.format("Proyek %s\n   Leader: %s\n   Jumlah anggota: %d",
                name, (projectLeader != null) ? projectLeader.getName() : "Tidak memiliki pemimpin", memberList.size());
    }
}
