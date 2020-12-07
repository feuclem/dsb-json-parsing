import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import java.io.File

object Serializer {
    fun <T> writeListInFile(path: String, dofus : List<T>) =
        ObjectMapper().registerModule(KotlinModule()).writeValue(File(path), dofus)

    fun <T> writeObjectInFile(path: String, dofus : T) =
        ObjectMapper().registerModule(KotlinModule()).writeValue(File(path), dofus)
}