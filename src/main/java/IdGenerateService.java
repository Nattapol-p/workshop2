import java.util.Random;

public class IdGenerateService {

    private Random random;

    public void setRandom(Random random) {
        this.random = random;
    }

    public String getDate(){
        // Dependency
        int id = random.nextInt(10);
        // Result
        return "CODE" + id;
    }

}
