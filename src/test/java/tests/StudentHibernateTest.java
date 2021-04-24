package tests;

import org.testng.annotations.Test;
import utils.StudentSQLService;

public class StudentHibernateTest {
    StudentSQLService student = new StudentSQLService();

    @Test
    public void studentList() {
        StudentSQLService.getAll();
    }

    @Test
    public void studentAdd() {
        student.add("Lily", 3);
        StudentSQLService.getAll();
    }

    @Test
    public void studentUpdate() {
        student.update(6, "Lilia Mur");
        StudentSQLService.getAll();
    }

    @Test
    public void studentDeleteFromList() {
        student.delete(6);
        StudentSQLService.getAll();
    }
}
