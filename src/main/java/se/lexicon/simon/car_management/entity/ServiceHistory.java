package se.lexicon.simon.car_management.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class ServiceHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 1000)
    private String history;

    public ServiceHistory(int id, String history) {
        this.id = id;
        setHistory(history);
    }

    public ServiceHistory(String history) {
        this(0, history);
    }

    public ServiceHistory() {}

    public int getId() {
        return id;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceHistory that = (ServiceHistory) o;
        return getId() == that.getId() &&
                Objects.equals(getHistory(), that.getHistory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getHistory());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ServiceHistory{");
        sb.append("id=").append(id);
        sb.append(", history='").append(history).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
