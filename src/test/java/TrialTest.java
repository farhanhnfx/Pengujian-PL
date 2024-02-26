import org.example.Trial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TrialTest {

    @Test
    void testTrialMethod() {
        Trial trial = new Trial();
        Assertions.assertEquals("True", trial.trialMethod());
    }
    @Test
    void testTrialMethod2() {
        System.out.println("testtttt222222");
    }

    @Test
    void testLagi() {
        Trial trial = new Trial();
        Assertions.assertSame(2, trial.ww());
//        Assertions.assertNotSame(10, 10);
    }
}
