


public class main {
    public static void main(String args[]) {
        SessionService sessionService = new SessionService(Integer.parseInt(args[0]));
        View sessionView = new SessionStart(sessionService);
        sessionView.display();
    }
}