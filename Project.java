import java.util.ArrayList;
import java.util.List;

public class Project {
    private String name;
    private Manager projectLeader;
    private List<Employee> memberList;

    public Project(String name) {
        this.name = name;
        this.memberList = new ArrayList<>();
    }

    public void addMember(Employee employee) {
        memberList.add(employee);
        employee.addProject(this);
    }

    public void removeMember(Employee employee) {
        memberList.remove(employee);
        employee.removeProject(this);
    }

    public String getName() {
        return name;
    }

    public Manager getProjectLeader() {
        return projectLeader;
    }

    public void setProjectLeader(Manager projectLeader) {
        this.projectLeader = projectLeader;
        projectLeader.addProject(this); // Add the project to the leader's list of projects
    }
    

    public List<Employee> getMemberList() {
        return memberList;
    }


    
    @Override
    public String toString() {
        return String.format("Proyek %s\n   Leader: %s\n   Jumlah anggota: %d",
                name, (projectLeader != null) ? projectLeader.getName() : "Tidak memiliki leader", memberList.size());
    }
}
