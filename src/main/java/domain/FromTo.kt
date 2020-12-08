package domain

data class FromTo(
    var min: Int,
    var max: Int? = null
) {
    init {
        max = if (max == null) {
            min
        } else {
            max
        }
    }
}