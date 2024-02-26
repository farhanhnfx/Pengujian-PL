import org.example.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StudentTest {
    @Test
    void testIsDoingMBKM() {
        Student student = new Student("siapa", 6, true);
        Assertions.assertTrue(student.isDoingMBKM());
    }
    @Test
    void testIsDoingMBKM1() {
        Student student = new Student("siapa2", 6, false);
        Assertions.assertFalse(student.isDoingMBKM());
    }
    @Test
    void testIsDoingMBKM2() {
        Student student = new Student("siapa3", 4, true);
        Assertions.assertFalse(student.isDoingMBKM());
    }
    @Test
    void testIsDoingMBKM3() {
        Student student = new Student("siapa4", 7, true);
        Assertions.assertEquals(true, student.isDoingMBKM());
    }
}
