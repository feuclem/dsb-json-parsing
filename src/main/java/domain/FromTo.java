package domain;

public class FromTo {
    private String min;
    private String max;

    public FromTo(String from, String to) {
        this.min = from;
        this.max = to;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }
}
