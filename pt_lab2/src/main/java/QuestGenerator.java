import java.util.Random;

public class QuestGenerator {
    private static int id = 1;
    private int min = 4;
    private int max = 8;

    public Quest generateRandom() {
        Random random = new Random();
        return new Quest(id++, random.nextInt((max - min) + 1) + min);
    }

    public Quest generate(int precision) {
        return new Quest(id++, precision);
    }
}