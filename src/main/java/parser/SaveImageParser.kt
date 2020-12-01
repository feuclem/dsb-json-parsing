package parser

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import domain.Equipement
import domain.SaveDirs
import java.io.BufferedOutputStream
import java.io.FileOutputStream
import java.io.OutputStream
import java.net.URL
import java.util.HashMap

class SaveImageParser {

    companion object {
        private val mapper = ObjectMapper().registerModule(KotlinModule())
    }

    private val equipementsJsonPath = javaClass.getResource("/equipements.json").path

    val amulettesSaveDirs = SaveDirs(
        javaClass.getResource("/equipements/amulettes.json").path,
        javaClass.getResource("/images/amulettes/").path
    )
    val anneauxSaveDirs = SaveDirs(
        javaClass.getResource("/equipements/anneaux.json").path,
        javaClass.getResource("/images/anneaux/").path
    )
    val armesSaveDirs = SaveDirs(
        javaClass.getResource("data/armes.json").getPath(),
        javaClass.getResource("images/armes/").getPath()
    )
    val bottesSaveDirs = SaveDirs(
        javaClass.getResource("/equipements/bottes.json").path,
        javaClass.getResource("/images/bottes/").path
    )
    val boucliersSaveDirs = SaveDirs(
        javaClass.getResource("/equipements/boucliers.json").path,
        javaClass.getResource("/images/boucliers/").path
    )
    val capesSaveDirs = SaveDirs(
        javaClass.getResource("/equipements/capes.json").path,
        javaClass.getResource("/images/capes/").path
    )
    val ceinturesSaveDirs = SaveDirs(
        javaClass.getResource("/equipements/ceintures.json").path,
        javaClass.getResource("/images/ceintures/").path
    )
    val coiffesSaveDirs = SaveDirs(
        javaClass.getResource("/equipements/coiffes.json").path,
        javaClass.getResource("/images/coiffes/").path
    )
    val dofusSaveDirs = SaveDirs(
        javaClass.getResource("/equipements/dofus.json").path,
        javaClass.getResource("/images/dofus/").path
    )
    val familiersSaveDirs = SaveDirs(
        javaClass.getResource("/equipements/familiers.json").path,
        javaClass.getResource("/images/familiers/").path
    )
    val monturesSaveDirs = SaveDirs(
        javaClass.getResource("/equipements/montures.json").path,
        javaClass.getResource("/images/montures/").path
    )
    val tropheesSaveDirs = SaveDirs(
        javaClass.getResource("/equipements/trophees.json").path,
        javaClass.getResource("/images/trophees/").path
    )

    fun handle(dirs: SaveDirs) {
        val equipmentList = deserializedEquipements()
        val imgUrlList: MutableMap<String, String> = HashMap()
        for ((_, name, _, imgUrl) in equipmentList) {
            imgUrlList[imgUrl] = name.replace("\\s+".toRegex(), "")
        }
        imgUrlList.forEach { (k: String?, v: String) ->
            val url = URL(k)
            val connection = url.openConnection()
            connection.setRequestProperty(
                "User-Agent",
                "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.29 Safari/537.36"
            )
            val `in` = connection.getInputStream()
            val out: OutputStream = BufferedOutputStream(FileOutputStream(dirs.pathToSave + v + ".png"))
            var i: Int
            while (`in`.read().also { i = it } != -1) {
                out.write(i)
            }
            `in`.close()
            out.close()
        }
    }

    private fun deserializedEquipements(): List<Equipement> {
        return mapper.readValue(equipementsJsonPath)
    }
}