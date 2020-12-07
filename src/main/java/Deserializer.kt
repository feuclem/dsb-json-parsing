import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue

object Deserializer {
    fun <T> readFile(path: String): List<T> =
        ObjectMapper().registerModule(KotlinModule()).readValue(path)
}