import org.junit.jupiter.api.Test;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

class Random6 extends Random {
    @Override
    public int nextInt(int bound) {
        return 6;
    }
}

class IdGenerateServiceTest {

    @Test
    public void getDate(){
        Random stub = new Random6();// Dependency
        // Dependency Injection
        // 1. Constructor Injection default ของ class
        IdGenerateService service = new IdGenerateService();
        // 2. setter Injection
        service.setRandom(stub);
        // 3. Method Injection
        String result = service.getDate();
        assertEquals("CODE6",result);
    }

    @Test
    public void getDate2(){
        SpyRandom spy = new SpyRandom();
        IdGenerateService service = new IdGenerateService();
        service.setRandom(spy);
        service.getDate();
        // Assert
        spy.verify(1);
    }
}

class SpyRandom extends Random {

    private int count;

    @Override
    public int nextInt(int bound) {
        count++;
        return 6;
    }

    public void verify(int expectedCount){
        assertTrue(count == expectedCount);
    }
}