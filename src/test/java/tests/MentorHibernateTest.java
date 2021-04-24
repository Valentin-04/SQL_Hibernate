package tests;

import org.testng.annotations.Test;
import utils.MentorSQLSerice;

public class MentorHibernateTest {

    MentorSQLSerice mentor = new MentorSQLSerice();

    @Test
    public void getMentorList() {
        MentorSQLSerice.getAll();
    }

    @Test
    public void mentorAddToList() {
        mentor.add("Lily");
        MentorSQLSerice.getAll();
    }

    @Test
    public void mentorUpdate() {
        mentor.update(4, "Lilia Mur");
        MentorSQLSerice.getAll();
    }

    @Test
    public void mentorDeleteFromList() {
        mentor.delete(4);
        MentorSQLSerice.getAll();
    }
}
