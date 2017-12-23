/**
 * Created by Sfill on 04.02.2017.
 */
//: concurrency/SerialNumberChecker.java
// Кажущиеся безопасными операции с появлением потоков
// перестают быть таковыми...
// {Args: 4}
import java.util.concurrent.*;

// Reuses storage so we don't run out of memory:
class CircularSet {
    private int[] array;
    private int len;
    private int index = 0;
    public CircularSet(int size) {
        array = new int[size];
        len = size;
        // Инициализируем значением, которое не производится
        // классом SerialNumberGenerator:
        for(int i = 0; i < size; i++)
            array[i] = -1;
    }
    public synchronized void add(int i) {
        array[index] = i;
        // Возврат индекса к началу с записью поверх старых значений:
        index = ++index % len;
    }
    public synchronized boolean contains(int val) {
        for(int i = 0; i < len; i++)
            if(array[i] == val) return true;
        return false;
    }
}
