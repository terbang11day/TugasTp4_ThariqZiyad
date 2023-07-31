import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimProyekTest {
    private SimProyek app;

    @BeforeEach
    public void setUp() {
        app = new SimProyek();
    }

    @Test
    public void testCreateProject() {
        app.createProject("Project A");
        app.createProject("Project B");
        app.createProject("Project C");

        assertEquals(3, app.projectList.size());
    }

    @Test
    public void testAddEmployee() {
        app.addEmployee("Manager A", "Manager", 3, 0.2, 1);
        app.addEmployee("Karyawan B", "Employee", 2, 0.1, 2);
        app.addEmployee("Manager C", "Manager", 4, 0.25, 3);

        assertEquals(3, app.employeeList.size());
    }

    @Test
    public void testAddProjectMember() {
        app.createProject("Project X");
        app.createProject("Project Y");

        app.addEmployee("Manager A", "Manager", 3, 0.2, 1);
        app.addEmployee("Karyawan B", "Employee", 2, 0.1, 2);

        app.addProjectMember(1, "Manager A");
        app.addProjectMember(1, "Karyawan B");
        app.addProjectMember(2, "Manager A");

        assertEquals(2, app.projectList.get(0).getMemberList().size());
        assertEquals(1, app.projectList.get(1).getMemberList().size());
    }
}
