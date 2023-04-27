import java.util.ArrayList;
import java.util.List;

public class AnswerBoard {
    public List<Answer> finishedQuests = new ArrayList<>();

    public synchronized void addAnswer(Answer answer) {
        finishedQuests.add(answer);
    }
}