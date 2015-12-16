public enum Frequency {
    DAILY("daily"),
    WEEKLY("weekly"),
    MONTHLY("monthly");

    //intervals of LocalDateTime
    private String frequency;

    Frequency(String frequency) {
        this.frequency = frequency;
    }

    public String getFrequency() {
        return frequency;
    }
}
