import java.util.ArrayList;
import java.util.List;

public class Project {
    // TODO: Tambahkan modifier untuk atribut
    String name;
    Manager projectLeader;
    List<Employee> memberList;

    // TODO: Lengkapi constructor
    public Project(String name) {
        this.name = name;
        this.memberList = new ArrayList<>();
    }

    // TODO: Lengkapi logika menambahkan anggota proyek
    public void addMember(Employee employee) {
        memberList.add(employee);
    }

    // TODO: Lengkapi logika menghapus anggota proyek
    public void removeMember(Employee employee) {
        memberList.remove(employee);
    }
}
