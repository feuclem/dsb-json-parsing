package domain.json

import com.fasterxml.jackson.annotation.JsonProperty

data class ArmeCharacteristiqueJson(
    @JsonProperty("PA")
    var pa: String = "",
    @JsonProperty("Portée")
    val po: String = "",
    @JsonProperty("CC")
    val critique: String = ""
)