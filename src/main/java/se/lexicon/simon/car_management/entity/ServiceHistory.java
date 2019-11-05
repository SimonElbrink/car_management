package se.lexicon.simon.car_management.entity;

import java.util.Objects;

public class ServiceHistory {

    private int id;
    private String history;

    public ServiceHistory(int id, String history) {
        this.id = id;
        this.history = history;
    }

    public ServiceHistory(String history) {
        this.history = history;
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
