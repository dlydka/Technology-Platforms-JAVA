import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Singular;
import lombok.extern.java.Log;
import java.util.List;
import java.util.logging.Level;

@Log
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Timeout implements Runnable {

    @Singular
    private List<Thread> threads;
    private long timeout;

    @Override
    public void run() {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException ex) {
            log.log(Level.WARNING, ex.getMessage(), ex);
        }
        for (Thread thread : threads) {
            thread.interrupt();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException ex) {
                log.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
    }

}

