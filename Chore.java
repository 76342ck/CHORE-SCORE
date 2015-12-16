import java.time.LocalDateTime;

public class Chore {
    private String name;
    private Frequency frequency;
    private Integer points;
    private LocalDateTime lastCompleted;

    public Chore(String name, Frequency frequency, int points) {
        this.name = name;
        this.frequency = frequency;
        this.points = points;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }
    public Frequency getFrequency() {
        return frequency;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    public Integer getPoints() {
        return points;
    }

    public void setLastCompleted(LocalDateTime lastCompleted) {
        this.lastCompleted = lastCompleted;
    }

    public void setComplete() {
        lastCompleted = LocalDateTime.now();
    }
    public LocalDateTime getLastCompleted() {
        return lastCompleted;
    }

    public String toString() {
        return getName();
    }
}
