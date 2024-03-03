import org.example.Student;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class StudentTest {
    private static ArrayList<Student> students;

    @BeforeAll
    public static void initClass() {
        students = new ArrayList<>();
    }
    @AfterAll
    public static void cleanClass() {
        students.clear();
    }

    @BeforeEach
    public void initMethod() {
        students.add(new Student("saya", 23));
        students.add(new Student("budi", 20));
        students.add(new Student("tono", 21));
    }
    @AfterEach
    public void cleanMethod() {
        students.clear();
    }

    @Test
    public void testDataCreation() {
        Assertions.assertNotNull(students);
        Assertions.assertFalse(students.isEmpty());
    }
    @Test
    void testStudentEnrollment() {
        for (Student student : students) {
            student.enrollCourse("Math");
            student.enrollCourse("Science");
            List<String> enrolledCourses = student.getEnrolledCourses();
            Assertions.assertNotNull(enrolledCourses);
            Assertions.assertEquals(2, enrolledCourses.size());
            Assertions.assertTrue(enrolledCourses.contains("Math"));
            Assertions.assertTrue(enrolledCourses.contains("Science"));
        }
    }
    @Test
    void testStudentGrade() {
        for (Student student : students) {
            student.setGrade("Math", "A");
            student.setGrade("Chemical", "D");
            Assertions.assertEquals("D", student.getGrade("Chemical"));
            Assertions.assertEquals("A", student.getGrade("Math"));
        }
    }
}
