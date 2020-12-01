package parser

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import domain.Arme
import java.io.File
import java.util.ArrayList
import java.util.function.Consumer

class ArmesParser {

    companion object {
        private val mapper = ObjectMapper().registerModule(KotlinModule())
    }

    private val armesDir = javaClass.getResource("/armes.json").path
    private val arcsDir = javaClass.getResource("/armes/arcs.json").path
    private val baguettesDir = javaClass.getResource("/armes/baguettes.json").path
    private val batonsDir = javaClass.getResource("/armes/batons.json").path
    private val daguesDir = javaClass.getResource("/armes/dagues.json").path
    private val epeesDir = javaClass.getResource("/armes/epees.json").path
    private val fauxDir = javaClass.getResource("/armes/faux.json").path
    private val marteauxDir = javaClass.getResource("/armes/marteaux.json").path
    private val pellesDir = javaClass.getResource("/armes/pelles.json").path

    fun writeArcs() {
        write(arcsDir, Arme.ARC)
    }

    fun writeBaguettes() {
        write(baguettesDir, Arme.BAGUETTE)
    }

    fun writeBatons() {
        write(batonsDir, Arme.BATON)
    }

    fun writeDagues() {
        write(daguesDir, Arme.DAGUE)
    }

    fun writeEpees() {
        write(epeesDir, Arme.EPEE)
    }

    fun writeFaux() {
        write(fauxDir, Arme.FAUX)
    }

    fun writeMarteaux() {
        write(marteauxDir, Arme.MARTEAU)
    }

    fun writePelles() {
        write(pellesDir, Arme.PELLE)
    }

    private fun write(pathWhereToWrite: String, type: String) {
        val armesJson: List<Arme> = deserializedArmes(armesDir)
        val armes: MutableList<Arme> = ArrayList<Arme>()
        armesJson.forEach {
            if (it.type == type) {
                armes.add(it)
            }
        }
        println("ARMES PARSER pour : $type, size : ${armes.size}")
        writeInFile(armes, pathWhereToWrite)
    }

    private fun writeInFile(dofus: List<Arme>, fileToWrite: String) {
        mapper.writeValue(File(fileToWrite), dofus)
    }

    private fun deserializedArmes(dir: String): List<Arme> {
        return mapper.readValue(dir)
    }
}