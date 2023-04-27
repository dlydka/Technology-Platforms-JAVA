import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class SessionService {

    private int maxThreads;

    public SessionService(int maxThreads) {
        this.maxThreads = maxThreads;
    }

    public Thread startGenericSession(long time) {
        QuestGenerator generator = new QuestGenerator();
        QuestBoard questBoard = new QuestBoard();
        AnswerBoard answerBoard = new AnswerBoard();
        SessionAdmin admin = new SessionAdmin(generator, questBoard);


        List<Worker> workers = new ArrayList<>();
        for (int i = 0; i < maxThreads; i++) {
            workers.add(new Worker(questBoard, answerBoard));
        }

        List<Thread> threads = new ArrayList<>();
        threads.add(new Thread(admin));
        for (Worker worker : workers) {
            threads.add(new Thread(worker));
        }


        for (Thread thread : threads) {
            thread.start();
        }

        Scanner scanner = new Scanner(System.in);
        int precision;
        Thread timeoutThread = null;
        while (true) {
            String operation = scanner.nextLine();
            if (operation.equals("x")) {
                Timeout timeout = Timeout.builder()
                        .timeout(time)
                        .threads(threads)
                        .build();

                timeoutThread = new Thread(timeout);
                timeoutThread.start();
                break;
            }
            else if (operation.equals("a")) {
                precision = scanner.nextInt();
                questBoard.put(List.of(generator.generate(precision)));
            }
        }
        return timeoutThread;
    }

}
