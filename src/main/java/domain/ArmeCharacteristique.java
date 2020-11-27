package domain;

import com.google.gson.annotations.SerializedName;

public class ArmeCharacteristique {
    @SerializedName("PA")
    private String pa;
    @SerializedName("Portée")
    private String po;
    @SerializedName("CC")
    private String coupCritique;
}
