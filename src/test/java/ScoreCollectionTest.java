import org.example.ScoreCollection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ScoreCollectionTest {
    @Test
    public void testAverageScore() {
        ScoreCollection scoreCollection = new ScoreCollection();
        scoreCollection.addScore(10);
        scoreCollection.addScore(2);
        Assertions.assertEquals(6, scoreCollection.averageScore());
    }
    @Test
    public void testAverageScore1() {
        ScoreCollection scoreCollection = new ScoreCollection();
        scoreCollection.addScore(10);
        Assertions.assertEquals(10, scoreCollection.averageScore());
    }
    @Test
    public void testAverageScore2() {
        ScoreCollection scoreCollection = new ScoreCollection();
        scoreCollection.addScore(12);
        scoreCollection.addScore(2);
        scoreCollection.addScore(4);
        scoreCollection.addScore(10);
        scoreCollection.addScore(8);
        Assertions.assertEquals(7.2, scoreCollection.averageScore());
    }

    @Test
    public void testTotalScore() {
        ScoreCollection scoreCollection = new ScoreCollection();
        scoreCollection.addScore(10);
        scoreCollection.addScore(2);
        Assertions.assertEquals(12, scoreCollection.totalScore());
    }
    @Test
    public void testTotalScore1() {
        ScoreCollection scoreCollection = new ScoreCollection();
        scoreCollection.addScore(10);
        Assertions.assertEquals(10, scoreCollection.totalScore());
    }
    @Test
    public void testTotalScore2() {
        ScoreCollection scoreCollection = new ScoreCollection();
        scoreCollection.addScore(12);
        scoreCollection.addScore(2);
        scoreCollection.addScore(4);
        scoreCollection.addScore(10);
        scoreCollection.addScore(8);
        Assertions.assertEquals(36, scoreCollection.totalScore());
    }

    @Test
    public void testAddScore() {
        ScoreCollection sc = new ScoreCollection();
        sc.addScore(6);
        Assertions.assertEquals(6, sc.getScores().get(0));
    }
}
