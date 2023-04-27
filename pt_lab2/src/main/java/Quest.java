import java.util.Objects;

import lombok.Builder;

@Builder
public class Quest {
    private int job_id = 0;
    private int precision;

    public Quest(int job_id, int precision) {
        this.job_id = job_id;
        this.precision = precision;
    }

    public int getJob_id() {
        return job_id;
    }

    public int getPrecision() {
        return precision;
    }

    @Override
    public String toString() {
        return "quest{" +
                "job_id=" + job_id +
                ", precision=" + precision +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quest quest = (Quest) o;
        return job_id == quest.job_id && precision == quest.precision;
    }

    @Override
    public int hashCode() {
        return Objects.hash(job_id, precision);
    }
}