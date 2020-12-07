package parser

import Deserializer.readFile
import domain.Equipement
import domain.SaveDirs
import java.io.BufferedOutputStream
import java.io.FileOutputStream
import java.io.OutputStream
import java.net.URL

class SaveImageParser {

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
        val equipmentList: List<Equipement> = readFile(equipementsJsonPath)
        val imgUrlList = equipmentList.map {
            it.imgUrl to it.name.replace("\\s+".toRegex(), "")
        }.toMap()
        imgUrlList.entries.map { (imgUrl: String, name: String) ->
            val url = URL(imgUrl)
            val connection = url.openConnection()
            connection.setRequestProperty(
                "User-Agent",
                "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.29 Safari/537.36"
            )
            println("RECUPERATION DE L'IMAGE $name")
            val `in` = connection.getInputStream()
            val out: OutputStream = BufferedOutputStream(FileOutputStream(dirs.pathToSave + name + ".png"))
            var i: Int
            while (`in`.read().also { i = it } != -1) out.write(i)
            println("FIN DE L'ECRITURE DE L'IMAGE $name")
            `in`.close()
            out.close()
        }
    }
}