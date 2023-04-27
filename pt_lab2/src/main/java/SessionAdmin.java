import java.util.List;

public class SessionAdmin implements Runnable {

    private QuestGenerator questGenerator;

    public SessionAdmin(QuestGenerator questGenerator, QuestBoard questBoard) {
        this.questGenerator = questGenerator;
        this.questBoard = questBoard;
    }

    private QuestBoard questBoard;

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                questBoard.put(List.of(questGenerator.generateRandom(), questGenerator.generateRandom(), questGenerator.generateRandom()));
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                break;
            }
        }
    }

}
