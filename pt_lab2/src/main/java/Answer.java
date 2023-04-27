import java.util.Objects;

public class Answer {
    private int job_id;
    private double pi_value;
    private double error;
    private int n_iterations;

    public Answer(int job_id, double pi_value, double error, int n_iterations) {
        this.job_id = job_id;
        this.pi_value = pi_value;
        this.error = error;
        this.n_iterations = n_iterations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return job_id == answer.job_id && Double.compare(answer.pi_value, pi_value) == 0 && Double.compare(answer.error, error) == 0 && n_iterations == answer.n_iterations;
    }

    @Override
    public int hashCode() {
        return Objects.hash(job_id, pi_value, error, n_iterations);
    }

    @Override
    public String toString() {
        return "Wynik obliczeń {" +
                "job_id = " + job_id +
                ", pi_value = " + pi_value +
                ", error = " + error +
                ", n_iterations = " + n_iterations +
                '}';
    }
}
