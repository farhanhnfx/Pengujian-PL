import org.example.Wallet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WalletTest {
    @Test
    public void testGetOwner() {
        Wallet wallet = new Wallet("Siapa Aku");
        Assertions.assertEquals("Siapa Aku", wallet.getOwner());
        wallet.setOwner("Bambang");
        Assertions.assertEquals("Bambang", wallet.getOwner());
    }
    @Test
    public void testAddCard() {
        Wallet wallet = new Wallet("Siapa Aku");
        wallet.addCard("KTM");
        Assertions.assertTrue(wallet.getCards().contains("KTM"));
        wallet.addCard("KTP");
        wallet.addCard("Credit Card");
        Assertions.assertFalse(wallet.getCards().contains("SIM"));
    }
    @Test
    public void testAddCoin() {
        Wallet wallet = new Wallet("Siapa Aku");
        wallet.addCoin(500);
        wallet.addCoin(100);
        wallet.addCoin(1000);
        wallet.addCoin(1000);
        wallet.addCoin(500);
        wallet.addCoin(1000);
        Assertions.assertEquals(2, wallet.getCoins().get(500));
        Assertions.assertEquals(1, wallet.getCoins().get(100));
        Assertions.assertEquals(3, wallet.getCoins().get(1000));
    }
    @Test
    public void testTakeCoin() {
        Wallet wallet = new Wallet("Siapa Aku");
        wallet.addCoin(500);
        wallet.addCoin(100);
        wallet.addCoin(1000);
        wallet.addCoin(1000);
        wallet.addCoin(500);
        wallet.addCoin(1000);

        wallet.takeCoin(100);
        wallet.takeCoin(500);
        wallet.takeCoin(1000);
        Assertions.assertEquals(0, wallet.getCoins().get(100));
        Assertions.assertEquals(1, wallet.getCoins().get(500));
        Assertions.assertEquals(2, wallet.getCoins().get(1000));
    }
    @Test
    public void testAddMoney() {
        Wallet wallet = new Wallet("Siapa Aku");
        wallet.addMoney(2000);
        wallet.addMoney(2000);
        Assertions.assertEquals(2, wallet.getMoneys().get(2000));
    }
    @Test
    public void testAddMoneyInvalid() {
        Wallet wallet = new Wallet("Siapa Aku");
        wallet.addMoney(4000);
        Assertions.assertNull(wallet.getMoneys().get(4000));
    }
    @Test
    public void testTakeMoney() {
        Wallet wallet = new Wallet("Siapa Aku");
        wallet.addMoney(5000);
        wallet.addMoney(100000);
        wallet.addMoney(20000);

        wallet.takeMoney(100000);
        Assertions.assertEquals(0, wallet.getMoneys().get(100000));
    }
    @Test
    public void testTakeMoneyInvalid() {
        Wallet wallet = new Wallet("Siapa Aku");
        wallet.addMoney(10000);
        wallet.takeMoney(50700);
        Assertions.assertEquals(0, wallet.getMoneys().get(5000));
    }
    @Test
    public void testCalculateCoins() {
        Wallet wallet = new Wallet("Siapa Aku");
        wallet.addCoin(500);
        wallet.addCoin(100);
        wallet.addCoin(1000);
        wallet.addCoin(1000);
        wallet.addCoin(500);
        wallet.addCoin(1000);

        int totalCoins = wallet.calculateCoins();
        Assertions.assertEquals(4100, totalCoins);
    }
    @Test
    public void testCalculateMoneys() {
        Wallet wallet = new Wallet("Siapa Aku");
        wallet.addMoney(5000);
        wallet.addMoney(100000);
        wallet.addMoney(20000);
        wallet.addMoney(10000);
        wallet.addMoney(5000);
        wallet.addMoney(50000);
        wallet.addMoney(30000);

        int totalMoneys = wallet.calculateMoneys();
        Assertions.assertEquals(190000, totalMoneys);
        Assertions.assertNull(wallet.getMoneys().get(30000));
    }
    @Test
    public void testGetMoneyAvailable() {
        Wallet wallet = new Wallet("Siapa Aku");
        wallet.addMoney(5000);
        wallet.addMoney(100000);
        wallet.addMoney(20000);
        wallet.addMoney(10000);
        wallet.addMoney(5000);
        wallet.addMoney(50000);
        wallet.addMoney(30000);
        wallet.addCoin(500);
        wallet.addCoin(100);
        wallet.addCoin(1000);
        wallet.addCoin(1000);
        wallet.addCoin(500);
        wallet.addCoin(1000);

        int total = wallet.getMoneyAvailable();
        Assertions.assertEquals(194100, total);
    }
}
