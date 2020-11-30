package domain

import com.fasterxml.jackson.annotation.JsonProperty

data class ArmeCharacteristique(
    @JsonProperty("PA")
    private var pa: String = "",
    @JsonProperty("Portée")
    private val po: String = "",
    @JsonProperty("CC")
    private val coupCritique: String = ""
)