import lombok.extern.java.Log;
import java.util.logging.Level;


@Log
public class SessionStart implements View {

    private final SessionService sessionService;

    public SessionStart(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @Override
    public void display() {
        System.out.println("Starting new session");
        try {
            sessionService.startGenericSession(3_000).join();
            System.out.println("Session ends");
        } catch (InterruptedException ex) {
            log.log(Level.WARNING, ex.getMessage(), ex);
        }
    }

}

