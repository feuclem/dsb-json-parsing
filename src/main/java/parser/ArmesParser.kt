package parser

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import domain.Arme
import domain.json.ArmeJson
import java.io.File
import java.util.ArrayList

object ArmesParser {

    private val arcsPath = javaClass.getResource("/armes/arcs.json").path
    private val baguettesPath = javaClass.getResource("/armes/baguettes.json").path
    private val batonsPath = javaClass.getResource("/armes/batons.json").path
    private val daguesPath = javaClass.getResource("/armes/dagues.json").path
    private val epeesPath = javaClass.getResource("/armes/epees.json").path
    private val fauxPath = javaClass.getResource("/armes/faux.json").path
    private val marteauxPath = javaClass.getResource("/armes/marteaux.json").path
    private val pellesPath = javaClass.getResource("/armes/pelles.json").path

    fun writeArcs(armesPath: String) {
        write(armesPath, arcsPath, ArmeJson.ARC)
    }

    fun writeBaguettes(armesPath: String) {
        write(armesPath, baguettesPath, ArmeJson.BAGUETTE)
    }

    fun writeBatons(armesPath: String) {
        write(armesPath, batonsPath, ArmeJson.BATON)
    }

    fun writeDagues(armesPath: String) {
        write(armesPath, daguesPath, ArmeJson.DAGUE)
    }

    fun writeEpees(armesPath: String) {
        write(armesPath, epeesPath, ArmeJson.EPEE)
    }

    fun writeFaux(armesPath: String) {
        write(armesPath, fauxPath, ArmeJson.FAUX)
    }

    fun writeMarteaux(armesPath: String) {
        write(armesPath, marteauxPath, ArmeJson.MARTEAU)
    }

    fun writePelles(armesPath: String) {
        write(armesPath, pellesPath, ArmeJson.PELLE)
    }

    private fun write(armesPath: String, pathWhereToWrite: String, type: String) {
        val armesJson = jacksonObjectMapper().readValue<List<ArmeJson>>(File(armesPath))
        val armes: MutableList<Arme> = mutableListOf()
        armesJson.forEach {
            if (it.type == type) {
                armes.add(it.toArme())
            }
        }
        println("ARMES PARSER pour : $type, size : ${armes.size}")
        jacksonObjectMapper().writeValue(File(pathWhereToWrite), armes)
    }
}