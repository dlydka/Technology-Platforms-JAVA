import java.lang.Math;

public class Worker implements Runnable {

    public Worker(QuestBoard questBoard, AnswerBoard answerBoard) {
        this.questBoard = questBoard;
        this.answerBoard = answerBoard;
    }

    private QuestBoard questBoard;
    private AnswerBoard answerBoard;

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                Quest quest = questBoard.take();
                System.out.println("Wątek o nr: " + Thread.currentThread().getId() +
                        " rozpocznie zadanie nr: " + quest.getJob_id());
                double error = 1, pi_value = 0;
                int n_iterations = 1;
                while(error > Math.pow(10, -1 * quest.getPrecision()) ) {
                    pi_value += Math.pow(-1, n_iterations - 1) / (2 * n_iterations - 1);
                    error = Math.abs(4 * pi_value - Math.PI);
                    n_iterations += 1;
                }
                pi_value *= 4;
                System.out.println("Wątek o nr: " + Thread.currentThread().getId() +
                        " zakończył obliczenia nr: " + quest.getJob_id());
                Answer answer = new Answer(quest.getJob_id(), pi_value, error, n_iterations);
                System.out.println(answer);
                answerBoard.addAnswer(answer);
            } catch (InterruptedException ex) {
                break;
            }
        }
    }

}