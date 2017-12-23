/**
 * Created by Sfill on 18.01.2017.
 */

// Конфликт потоков.

public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    public int next() {
        ++ currentEvenValue;  // Опасная точка!
        ++currentEvenValue;
        return currentEvenValue;
    }
    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
