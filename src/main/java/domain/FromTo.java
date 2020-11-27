package domain;

import com.google.gson.annotations.SerializedName;

public class FromTo {
    @SerializedName("min")
    private String from;
    @SerializedName("max")
    private String to;

    public FromTo(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
