package parser

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import domain.json.EquipementJson
import domain.SaveDirs
import java.io.BufferedOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import java.net.URL

object SaveImageParser {

    val amulettesSaveDirs = SaveDirs(
        javaClass.getResource("/equipements/amulettes.json").path,
        javaClass.getResource("/images/amulettes/").path
    )
    val anneauxSaveDirs = SaveDirs(
        javaClass.getResource("/equipements/anneaux.json").path,
        javaClass.getResource("/images/anneaux/").path
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


    val arcsSaveDirs = SaveDirs(
        javaClass.getResource("/armes/arcs.json").path,
        javaClass.getResource("/images/arcs/").path
    )
    val baguettesSaveDirs = SaveDirs(
        javaClass.getResource("/armes/baguettes.json").path,
        javaClass.getResource("/images/baguettes/").path
    )
    val batonsSaveDirs = SaveDirs(
        javaClass.getResource("/armes/batons.json").path,
        javaClass.getResource("/images/batons/").path
    )
    val daguesSaveDirs = SaveDirs(
        javaClass.getResource("/armes/dagues.json").path,
        javaClass.getResource("/images/dagues/").path
    )
    val epeesSaveDirs = SaveDirs(
        javaClass.getResource("/armes/epees.json").path,
        javaClass.getResource("/images/epees/").path
    )
    val fauxSaveDirs = SaveDirs(
        javaClass.getResource("/armes/faux.json").path,
        javaClass.getResource("/images/faux/").path
    )
    val marteauxSaveDirs = SaveDirs(
        javaClass.getResource("/equipements/marteaux.json").path,
        javaClass.getResource("/images/marteaux/").path
    )
    val pellesSaveDirs = SaveDirs(
        javaClass.getResource("/equipements/pelles.json").path,
        javaClass.getResource("/images/pelles/").path
    )

    fun handle(equipementsPath: String, dirs: SaveDirs) {
        val equipmentList = jacksonObjectMapper().readValue<List<EquipementJson>>(File(equipementsPath))
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