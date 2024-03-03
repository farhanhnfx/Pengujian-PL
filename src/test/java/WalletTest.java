import org.example.Wallet;
import org.junit.jupiter.api.*;

import java.util.HashMap;

public class WalletTest {
    private Wallet myWallet;

    @BeforeAll
    public static void initClass() {

    }
    @BeforeEach
    public void initMethod() {
        myWallet = new Wallet("John Doe");
    }
    @AfterEach
    public void cleanMethod() {
        myWallet = null;
    }
    @AfterAll
    public static void cleanClass() {

    }

    @Test
    public void testOwner() {
        Assertions.assertEquals("John Doe", myWallet.getOwner());
        myWallet.setOwner("Jane Doe");
        Assertions.assertEquals("Jane Doe", myWallet.getOwner());
    }
    @Test
    public void testCard() {
        myWallet.addCard("Credit Card");
        myWallet.addCard("KTM");
        Assertions.assertTrue(myWallet.getCards().contains("Credit Card"));
        Assertions.assertTrue(myWallet.getCards().contains("KTM"));
        myWallet.removeCard("Credit Card");
        Assertions.assertFalse(myWallet.getCards().contains("Credit Card"));
        Assertions.assertTrue(myWallet.getCards().contains("KTM"));
    }
    @Test
    public void testCoin() {
        myWallet.addCoin(500);
        myWallet.addCoin(1000);
        HashMap<Integer, Integer> coins = myWallet.getCoins();
        Assertions.assertNotNull(coins);
        Assertions.assertEquals(1, coins.get(500));
        Assertions.assertEquals(1, coins.get(1000));
        myWallet.takeCoin(500);
        Assertions.assertEquals(0, coins.get(500));
    }
    @Test
    public void testMoney() {
        myWallet.addMoney(10000);
        myWallet.addMoney(5000);
        HashMap<Integer, Integer> moneys = myWallet.getMoneys();
        Assertions.assertNotNull(moneys);
        Assertions.assertEquals(1, moneys.get(10000));
        Assertions.assertEquals(1, moneys.get(5000));
        myWallet.takeMoney(5000);
        Assertions.assertEquals(1, moneys.get(10000));
        Assertions.assertEquals(0, moneys.get(5000));
    }
    @Test
    public void testInvalidCoin() {
        myWallet.addCoin(50);
        myWallet.addCoin(300);
        myWallet.addCoin(750);
        Assertions.assertFalse(myWallet.getCoins().containsKey(50));
        Assertions.assertFalse(myWallet.getCoins().containsKey(300));
        Assertions.assertFalse(myWallet.getCoins().containsKey(750));
    }
    @Test
    public void testInvalidMoney() {
        myWallet.addMoney(3000);
        myWallet.addMoney(15000);
        Assertions.assertFalse(myWallet.getMoneys().containsKey(3000));
        Assertions.assertFalse(myWallet.getMoneys().containsKey(15000));
    }
    @Test
    public void testCalculateCoins() {
        myWallet.addCoin(100);
        myWallet.addCoin(500);
        myWallet.addCoin(1000);
        myWallet.addCoin(5000);
        Assertions.assertEquals(1600, myWallet.calculateCoins());
    }
    @Test
    public void testCalculateMoneys() {
        myWallet.addMoney(5000);
        myWallet.addMoney(10000);
        myWallet.addMoney(500);
        Assertions.assertEquals(15000, myWallet.calculateMoneys());
    }
    @Test
    public void testGetMoneyAvailable() {
        myWallet.addCoin(100);
        myWallet.addMoney(100000);
        myWallet.addCoin(400);
        myWallet.addMoney(200000);
        Assertions.assertEquals(100100, myWallet.getMoneyAvailable());
    }
}
