package domain

class FromTo(var min: String) {
    var max: String? = null

    init {
        max = if (max == null) {
            min
        } else {
            max
        }
    }
}