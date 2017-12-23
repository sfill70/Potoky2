/**
 * Created by Sfill on 04.02.2017.
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;
    public /*synchronized*/ static int nextSerialNumber() {
        return serialNumber++; // Операция не является потоково-безопасной
    }
}
