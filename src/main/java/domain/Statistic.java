package domain;

import com.google.gson.annotations.SerializedName;

public class Statistic {
    @SerializedName("Vitalité")
    private FromTo vitalite;
    @SerializedName("PA")
    private FromTo pa;
    @SerializedName("PM")
    private FromTo pm;
    @SerializedName("Portée")
    private FromTo po;
    @SerializedName("Sagesse")
    private FromTo sagesse;
    @SerializedName("Soins")
    private FromTo soins;
    @SerializedName(value = "% Critique", alternate = {
            "1% Critique",
            "2% Critique",
            "3% Critique",
            "4% Critique",
            "5% Critique",
            "6% Critique",
            "7% Critique",
            "8% Critique",
            "9% Critique",
            "10% Critique",
            "11% Critique",
            "12% Critique",
            "13% Critique",
            "14% Critique",
            "15% Critique",
            "16% Critique",
            "17% Critique",
            "18% Critique",
            "19% Critique",
            "20% Critique",
            "-1% Critique",
            "-2% Critique",
            "-3% Critique",
            "-4% Critique",
            "-5% Critique",
            "-6% Critique",
            "-7% Critique",
            "-8% Critique",
            "-9% Critique",
            "-10% Critique",
            "-11% Critique",
            "-12% Critique",
            "-13% Critique",
            "-14% Critique",
            "-15% Critique",
            "-16% Critique",
            "-17% Critique",
            "-18% Critique",
            "-19% Critique",
            "-20% Critique"
    })
    private FromTo critique;
    @SerializedName("Puissance")
    private FromTo puissance;
    @SerializedName("Force")
    private FromTo force;
    @SerializedName("Intelligence")
    private FromTo intelligence;
    @SerializedName("Chance")
    private FromTo chance;
    @SerializedName("Agilité")
    private FromTo agilite;
    @SerializedName("Initiative")
    private FromTo initiative;
    @SerializedName("Dommages Neutre")
    private FromTo dommagesNeutre;
    @SerializedName("Dommages Terre")
    private FromTo dommagesTerre;
    @SerializedName("Dommages Feu")
    private FromTo dommagesFeu;
    @SerializedName("Dommages Eau")
    private FromTo dommagesEau;
    @SerializedName("Dommages Air")
    private FromTo dommagesAir;
    @SerializedName("Dommages")
    private FromTo dommages;
    @SerializedName("(dommages Neutre)")
    private FromTo dommagesArmeNeutre;
    @SerializedName("(dommages Terre)")
    private FromTo dommagesArmeTerre;
    @SerializedName("(dommages Feu)")
    private FromTo dommagesArmeFeu;
    @SerializedName("(dommages Eau)")
    private FromTo dommagesArmeEau;
    @SerializedName("Dommages Critiques")
    private FromTo dommagesCritiques;
    @SerializedName("Dommages Poussée")
    private FromTo dommagesPoussee;
    @SerializedName(value = "% Résistance Neutre", alternate = {
            "1% Résistance Neutre",
            "2% Résistance Neutre",
            "3% Résistance Neutre",
            "4% Résistance Neutre",
            "5% Résistance Neutre",
            "6% Résistance Neutre",
            "7% Résistance Neutre",
            "8% Résistance Neutre",
            "9% Résistance Neutre",
            "10% Résistance Neutre",
            "-1% Résistance Neutre",
            "-2% Résistance Neutre",
            "-3% Résistance Neutre",
            "-4% Résistance Neutre",
            "-5% Résistance Neutre",
            "-6% Résistance Neutre",
            "-7% Résistance Neutre",
            "-8% Résistance Neutre",
            "-9% Résistance Neutre",
            "-10% Résistance Neutre"
    })
    private FromTo pourcentResistanceNeutre;
    @SerializedName(value = "% Résistance Terre", alternate = {
            "1% Résistance Terre",
            "2% Résistance Terre",
            "3% Résistance Terre",
            "4% Résistance Terre",
            "5% Résistance Terre",
            "6% Résistance Terre",
            "7% Résistance Terre",
            "8% Résistance Terre",
            "9% Résistance Terre",
            "10% Résistance Terre",
            "-1% Résistance Terre",
            "-2% Résistance Terre",
            "-3% Résistance Terre",
            "-4% Résistance Terre",
            "-5% Résistance Terre",
            "-6% Résistance Terre",
            "-7% Résistance Terre",
            "-8% Résistance Terre",
            "-9% Résistance Terre",
            "-10% Résistance Terre"
    })
    private FromTo pourcentResistanceTerre;
    @SerializedName(value = "% Résistance Feu", alternate = {
            "1% Résistance Feu",
            "2% Résistance Feu",
            "3% Résistance Feu",
            "4% Résistance Feu",
            "5% Résistance Feu",
            "6% Résistance Feu",
            "7% Résistance Feu",
            "8% Résistance Feu",
            "9% Résistance Feu",
            "10% Résistance Feu",
            "-1% Résistance Feu",
            "-2% Résistance Feu",
            "-3% Résistance Feu",
            "-4% Résistance Feu",
            "-5% Résistance Feu",
            "-6% Résistance Feu",
            "-7% Résistance Feu",
            "-8% Résistance Feu",
            "-9% Résistance Feu",
            "-10% Résistance Feu"
    })
    private FromTo pourcentResistanceFeu;
    @SerializedName(value = "% Résistance Eau", alternate = {
            "1% Résistance Eau",
            "2% Résistance Eau",
            "3% Résistance Eau",
            "4% Résistance Eau",
            "5% Résistance Eau",
            "6% Résistance Eau",
            "7% Résistance Eau",
            "8% Résistance Eau",
            "9% Résistance Eau",
            "10% Résistance Eau",
            "-1% Résistance Eau",
            "-2% Résistance Eau",
            "-3% Résistance Eau",
            "-4% Résistance Eau",
            "-5% Résistance Eau",
            "-6% Résistance Eau",
            "-7% Résistance Eau",
            "-8% Résistance Eau",
            "-9% Résistance Eau",
            "-10% Résistance Eau"
    })
    private FromTo pourcentResistanceEau;
    @SerializedName(value = "% Résistance Air", alternate = {
            "1% Résistance Air",
            "2% Résistance Air",
            "3% Résistance Air",
            "4% Résistance Air",
            "5% Résistance Air",
            "6% Résistance Air",
            "7% Résistance Air",
            "8% Résistance Air",
            "9% Résistance Air",
            "10% Résistance Air",
            "-1% Résistance Air",
            "-2% Résistance Air",
            "-3% Résistance Air",
            "-4% Résistance Air",
            "-5% Résistance Air",
            "-6% Résistance Air",
            "-7% Résistance Air",
            "-8% Résistance Air",
            "-9% Résistance Air",
            "-10% Résistance Air"
    })
    private FromTo pourcentResistanceAir;
    @SerializedName("Résistance Critiques")
    private FromTo resistanceCritiques;
    @SerializedName("Résistance Poussée")
    private FromTo resistancePoussee;
    @SerializedName("Tacle")
    private FromTo tacle;
    @SerializedName("Fuite")
    private FromTo fuite;
    @SerializedName("Esquive PA")
    private FromTo esquivePa;
    @SerializedName("Esquive PM")
    private FromTo esquivePm;
    @SerializedName("Retrait PA")
    private FromTo retraitPa;
    @SerializedName("Retrait PM")
    private FromTo retraitPm;
    @SerializedName("Résistance Neutre")
    private FromTo resistanceFixeNeutre;
    @SerializedName("Résistance Terre")
    private FromTo resistanceFixeTerre;
    @SerializedName("Résistance Feu")
    private FromTo resistanceFixeFeu;
    @SerializedName("Résistance Eau")
    private FromTo resistanceFixeEau;
    @SerializedName("Résistance Air")
    private FromTo resistanceFixeAir;
    @SerializedName("Prospection")
    private FromTo prospection;
    @SerializedName("Invocations")
    private FromTo invocations;
    @SerializedName(value = "1% Résistance distance", alternate = {
            "2% Résistance distance",
            "3% Résistance distance",
            "4% Résistance distance",
            "5% Résistance distance",
            "6% Résistance distance",
            "7% Résistance distance",
            "8% Résistance distance",
            "9% Résistance distance",
            "10% Résistance distance",
            "11% Résistance distance",
            "12% Résistance distance",
            "13% Résistance distance",
            "14% Résistance distance",
            "15% Résistance distance",
            "16% Résistance distance",
            "17% Résistance distance",
            "18% Résistance distance",
            "19% Résistance distance",
            "20% Résistance distance",
            "-1% Résistance distance",
            "-2% Résistance distance",
            "-3% Résistance distance",
            "-4% Résistance distance",
            "-5% Résistance distance",
            "-6% Résistance distance",
            "-7% Résistance distance",
            "-8% Résistance distance",
            "-9% Résistance distance",
            "-10% Résistance distance",
            "-11% Résistance distance",
            "-12% Résistance distance",
            "-13% Résistance distance",
            "-14% Résistance distance",
            "-15% Résistance distance",
            "-16% Résistance distance",
            "-17% Résistance distance",
            "-18% Résistance distance",
            "-19% Résistance distance",
            "-20% Résistance distance"
    })
    private FromTo pourcentResistanceDistance;
    @SerializedName(value = "1% Résistance mêlée", alternate = {
            "2% Résistance mêlée",
            "3% Résistance mêlée",
            "4% Résistance mêlée",
            "5% Résistance mêlée",
            "6% Résistance mêlée",
            "7% Résistance mêlée",
            "8% Résistance mêlée",
            "9% Résistance mêlée",
            "10% Résistance mêlée",
            "11% Résistance mêlée",
            "12% Résistance mêlée",
            "13% Résistance mêlée",
            "14% Résistance mêlée",
            "15% Résistance mêlée",
            "16% Résistance mêlée",
            "17% Résistance mêlée",
            "18% Résistance mêlée",
            "19% Résistance mêlée",
            "20% Résistance mêlée",
            "-1% Résistance mêlée",
            "-2% Résistance mêlée",
            "-3% Résistance mêlée",
            "-4% Résistance mêlée",
            "-5% Résistance mêlée",
            "-6% Résistance mêlée",
            "-7% Résistance mêlée",
            "-8% Résistance mêlée",
            "-9% Résistance mêlée",
            "-10% Résistance mêlée",
            "-11% Résistance mêlée",
            "-12% Résistance mêlée",
            "-13% Résistance mêlée",
            "-14% Résistance mêlée",
            "-15% Résistance mêlée",
            "-16% Résistance mêlée",
            "-17% Résistance mêlée",
            "-18% Résistance mêlée",
            "-19% Résistance mêlée",
            "-20% Résistance mêlée"
    })
    private FromTo pourcentResistanceMelee;
    @SerializedName(value = "% Dommages mêlée", alternate = {
            "2% Dommages mêlée",
            "3% Dommages mêlée",
            "4% Dommages mêlée",
            "5% Dommages mêlée",
            "6% Dommages mêlée",
            "7% Dommages mêlée",
            "8% Dommages mêlée",
            "9% Dommages mêlée",
            "10% Dommages mêlée",
            "11% Dommages mêlée",
            "12% Dommages mêlée",
            "13% Dommages mêlée",
            "14% Dommages mêlée",
            "15% Dommages mêlée",
            "16% Dommages mêlée",
            "17% Dommages mêlée",
            "18% Dommages mêlée",
            "19% Dommages mêlée",
            "20% Dommages mêlée",
            "-1% Dommages mêlée",
            "-2% Dommages mêlée",
            "-3% Dommages mêlée",
            "-4% Dommages mêlée",
            "-5% Dommages mêlée",
            "-6% Dommages mêlée",
            "-7% Dommages mêlée",
            "-8% Dommages mêlée",
            "-9% Dommages mêlée",
            "-10% Dommages mêlée",
            "-11% Dommages mêlée",
            "-12% Dommages mêlée",
            "-13% Dommages mêlée",
            "-14% Dommages mêlée",
            "-15% Dommages mêlée",
            "-16% Dommages mêlée",
            "-17% Dommages mêlée",
            "-18% Dommages mêlée",
            "-19% Dommages mêlée",
            "-20% Dommages mêlée"
    })
    private FromTo pourcentDommagesMelee;
    @SerializedName(value = "% Dommages distance", alternate = {
            "2% Dommages distance",
            "3% Dommages distance",
            "4% Dommages distance",
            "5% Dommages distance",
            "6% Dommages distance",
            "7% Dommages distance",
            "8% Dommages distance",
            "9% Dommages distance",
            "10% Dommages distance",
            "11% Dommages distance",
            "12% Dommages distance",
            "13% Dommages distance",
            "14% Dommages distance",
            "15% Dommages distance",
            "16% Dommages distance",
            "17% Dommages distance",
            "18% Dommages distance",
            "19% Dommages distance",
            "20% Dommages distance",
            "-1% Dommages distance",
            "-2% Dommages distance",
            "-3% Dommages distance",
            "-4% Dommages distance",
            "-5% Dommages distance",
            "-6% Dommages distance",
            "-7% Dommages distance",
            "-8% Dommages distance",
            "-9% Dommages distance",
            "-10% Dommages distance",
            "-11% Dommages distance",
            "-12% Dommages distance",
            "-13% Dommages distance",
            "-14% Dommages distance",
            "-15% Dommages distance",
            "-16% Dommages distance",
            "-17% Dommages distance",
            "-18% Dommages distance",
            "-19% Dommages distance",
            "-20% Dommages distance"
    })
    private FromTo pourcentDommagesDistance;
    @SerializedName("Puissance (pièges)")
    private FromTo puissancePieges;
    @SerializedName("Dommages Pièges")
    private FromTo dommagesPieges;
    @SerializedName(value = "% Dommages aux sorts", alternate = {
            "2% Dommages aux sorts",
            "3% Dommages aux sorts",
            "4% Dommages aux sorts",
            "5% Dommages aux sorts",
            "6% Dommages aux sorts",
            "7% Dommages aux sorts",
            "8% Dommages aux sorts",
            "9% Dommages aux sorts",
            "10% Dommages aux sorts",
            "11% Dommages aux sorts",
            "12% Dommages aux sorts",
            "13% Dommages aux sorts",
            "14% Dommages aux sorts",
            "15% Dommages aux sorts",
            "16% Dommages aux sorts",
            "17% Dommages aux sorts",
            "18% Dommages aux sorts",
            "19% Dommages aux sorts",
            "20% Dommages aux sorts",
            "-1% Dommages aux sorts",
            "-2% Dommages aux sorts",
            "-3% Dommages aux sorts",
            "-4% Dommages aux sorts",
            "-5% Dommages aux sorts",
            "-6% Dommages aux sorts",
            "-7% Dommages aux sorts",
            "-8% Dommages aux sorts",
            "-9% Dommages aux sorts",
            "-10% Dommages aux sorts",
            "-11% Dommages aux sorts",
            "-12% Dommages aux sorts",
            "-13% Dommages aux sorts",
            "-14% Dommages aux sorts",
            "-15% Dommages aux sorts",
            "-16% Dommages aux sorts",
            "-17% Dommages aux sorts",
            "-18% Dommages aux sorts",
            "-19% Dommages aux sorts",
            "-20% Dommages aux sorts"
    })
    private FromTo dommagesSorts;
    @SerializedName("Pods")
    private FromTo pods;

    public FromTo getVitalite() {
        return vitalite;
    }

    public void setVitalite(FromTo vitalite) {
        this.vitalite = vitalite;
    }

    public FromTo getSagesse() {
        return sagesse;
    }

    public void setSagesse(FromTo sagesse) {
        this.sagesse = sagesse;
    }

    public FromTo getSoins() {
        return soins;
    }

    public void setSoins(FromTo soins) {
        this.soins = soins;
    }

    public FromTo getCritique() {
        return critique;
    }

    public void setCritique(FromTo critique) {
        this.critique = critique;
    }

    public FromTo getPuissance() {
        return puissance;
    }

    public void setPuissance(FromTo puissance) {
        this.puissance = puissance;
    }

    public FromTo getForce() {
        return force;
    }

    public void setForce(FromTo force) {
        this.force = force;
    }

    public FromTo getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(FromTo intelligence) {
        this.intelligence = intelligence;
    }

    public FromTo getChance() {
        return chance;
    }

    public void setChance(FromTo chance) {
        this.chance = chance;
    }

    public FromTo getAgilite() {
        return agilite;
    }

    public void setAgilite(FromTo agilite) {
        this.agilite = agilite;
    }

    public FromTo getInitiative() {
        return initiative;
    }

    public void setInitiative(FromTo initiative) {
        this.initiative = initiative;
    }

    public FromTo getDommagesNeutre() {
        return dommagesNeutre;
    }

    public void setDommagesNeutre(FromTo dommagesNeutre) {
        this.dommagesNeutre = dommagesNeutre;
    }

    public FromTo getDommagesTerre() {
        return dommagesTerre;
    }

    public void setDommagesTerre(FromTo dommagesTerre) {
        this.dommagesTerre = dommagesTerre;
    }

    public FromTo getDommagesFeu() {
        return dommagesFeu;
    }

    public void setDommagesFeu(FromTo dommagesFeu) {
        this.dommagesFeu = dommagesFeu;
    }

    public FromTo getDommagesEau() {
        return dommagesEau;
    }

    public void setDommagesEau(FromTo dommagesEau) {
        this.dommagesEau = dommagesEau;
    }

    public FromTo getDommagesAir() {
        return dommagesAir;
    }

    public void setDommagesAir(FromTo dommagesAir) {
        this.dommagesAir = dommagesAir;
    }

    public FromTo getDommagesCritiques() {
        return dommagesCritiques;
    }

    public void setDommagesCritiques(FromTo dommagesCritiques) {
        this.dommagesCritiques = dommagesCritiques;
    }

    public FromTo getPourcentResistanceNeutre() {
        return pourcentResistanceNeutre;
    }

    public void setPourcentResistanceNeutre(FromTo pourcentResistanceNeutre) {
        this.pourcentResistanceNeutre = pourcentResistanceNeutre;
    }

    public FromTo getPourcentResistanceTerre() {
        return pourcentResistanceTerre;
    }

    public void setPourcentResistanceTerre(FromTo pourcentResistanceTerre) {
        this.pourcentResistanceTerre = pourcentResistanceTerre;
    }

    public FromTo getPourcentResistanceFeu() {
        return pourcentResistanceFeu;
    }

    public void setPourcentResistanceFeu(FromTo pourcentResistanceFeu) {
        this.pourcentResistanceFeu = pourcentResistanceFeu;
    }

    public FromTo getPourcentResistanceEau() {
        return pourcentResistanceEau;
    }

    public void setPourcentResistanceEau(FromTo pourcentResistanceEau) {
        this.pourcentResistanceEau = pourcentResistanceEau;
    }

    public FromTo getPourcentResistanceAir() {
        return pourcentResistanceAir;
    }

    public void setPourcentResistanceAir(FromTo pourcentResistanceAir) {
        this.pourcentResistanceAir = pourcentResistanceAir;
    }

    public FromTo getResistanceCritiques() {
        return resistanceCritiques;
    }

    public void setResistanceCritiques(FromTo resistanceCritiques) {
        this.resistanceCritiques = resistanceCritiques;
    }

    public FromTo getTacle() {
        return tacle;
    }

    public void setTacle(FromTo tacle) {
        this.tacle = tacle;
    }

    public FromTo getDommagesPoussee() {
        return dommagesPoussee;
    }

    public void setDommagesPoussee(FromTo dommagesPoussee) {
        this.dommagesPoussee = dommagesPoussee;
    }

    public FromTo getResistancePoussee() {
        return resistancePoussee;
    }

    public void setResistancePoussee(FromTo resistancePoussee) {
        this.resistancePoussee = resistancePoussee;
    }

    public FromTo getFuite() {
        return fuite;
    }

    public void setFuite(FromTo fuite) {
        this.fuite = fuite;
    }

    public FromTo getEsquivePa() {
        return esquivePa;
    }

    public void setEsquivePa(FromTo esquivePa) {
        this.esquivePa = esquivePa;
    }

    public FromTo getEsquivePm() {
        return esquivePm;
    }

    public void setEsquivePm(FromTo esquivePm) {
        this.esquivePm = esquivePm;
    }

    public FromTo getRetraitPa() {
        return retraitPa;
    }

    public void setRetraitPa(FromTo retraitPa) {
        this.retraitPa = retraitPa;
    }

    public FromTo getRetraitPm() {
        return retraitPm;
    }

    public void setRetraitPm(FromTo retraitPm) {
        this.retraitPm = retraitPm;
    }

    public FromTo getResistanceFixeTerre() {
        return resistanceFixeTerre;
    }

    public void setResistanceFixeTerre(FromTo resistanceFixeTerre) {
        this.resistanceFixeTerre = resistanceFixeTerre;
    }

    public FromTo getResistanceFixeFeu() {
        return resistanceFixeFeu;
    }

    public void setResistanceFixeFeu(FromTo resistanceFixeFeu) {
        this.resistanceFixeFeu = resistanceFixeFeu;
    }

    public FromTo getResistanceFixeEau() {
        return resistanceFixeEau;
    }

    public void setResistanceFixeEau(FromTo resistanceFixeEau) {
        this.resistanceFixeEau = resistanceFixeEau;
    }

    public FromTo getResistanceFixeAir() {
        return resistanceFixeAir;
    }

    public void setResistanceFixeAir(FromTo resistanceFixeAir) {
        this.resistanceFixeAir = resistanceFixeAir;
    }

    public FromTo getPourcentResistanceDistance() {
        return pourcentResistanceDistance;
    }

    public void setPourcentResistanceDistance(FromTo pourcentResistanceDistance) {
        this.pourcentResistanceDistance = pourcentResistanceDistance;
    }

    public FromTo getPourcentResistanceMelee() {
        return pourcentResistanceMelee;
    }

    public void setPourcentResistanceMelee(FromTo pourcentResistanceMelee) {
        this.pourcentResistanceMelee = pourcentResistanceMelee;
    }

    public FromTo getPourcentDommagesMelee() {
        return pourcentDommagesMelee;
    }

    public void setPourcentDommagesMelee(FromTo pourcentDommagesMelee) {
        this.pourcentDommagesMelee = pourcentDommagesMelee;
    }

    public FromTo getPourcentDommagesDistance() {
        return pourcentDommagesDistance;
    }

    public void setPourcentDommagesDistance(FromTo pourcentDommagesDistance) {
        this.pourcentDommagesDistance = pourcentDommagesDistance;
    }

    public FromTo getPo() {
        return po;
    }

    public void setPo(FromTo po) {
        this.po = po;
    }

    public FromTo getPa() {
        return pa;
    }

    public void setPa(FromTo pa) {
        this.pa = pa;
    }

    public FromTo getPm() {
        return pm;
    }

    public void setPm(FromTo pm) {
        this.pm = pm;
    }

    public FromTo getDommagesArmeNeutre() {
        return dommagesArmeNeutre;
    }

    public void setDommagesArmeNeutre(FromTo dommagesArmeNeutre) {
        this.dommagesArmeNeutre = dommagesArmeNeutre;
    }

    public FromTo getDommagesArmeTerre() {
        return dommagesArmeTerre;
    }

    public void setDommagesArmeTerre(FromTo dommagesArmeTerre) {
        this.dommagesArmeTerre = dommagesArmeTerre;
    }

    public FromTo getDommagesArmeFeu() {
        return dommagesArmeFeu;
    }

    public void setDommagesArmeFeu(FromTo dommagesArmeFeu) {
        this.dommagesArmeFeu = dommagesArmeFeu;
    }

    public FromTo getDommagesArmeEau() {
        return dommagesArmeEau;
    }

    public void setDommagesArmeEau(FromTo dommagesArmeEau) {
        this.dommagesArmeEau = dommagesArmeEau;
    }

    public FromTo getDommages() {
        return dommages;
    }

    public void setDommages(FromTo dommages) {
        this.dommages = dommages;
    }

    public FromTo getProspection() {
        return prospection;
    }

    public void setProspection(FromTo prospection) {
        this.prospection = prospection;
    }

    public FromTo getInvocations() {
        return invocations;
    }

    public void setInvocations(FromTo invocations) {
        this.invocations = invocations;
    }

    public FromTo getPuissancePieges() {
        return puissancePieges;
    }

    public void setPuissancePieges(FromTo puissancePieges) {
        this.puissancePieges = puissancePieges;
    }

    public FromTo getDommagesPieges() {
        return dommagesPieges;
    }

    public void setDommagesPieges(FromTo dommagesPieges) {
        this.dommagesPieges = dommagesPieges;
    }

    public FromTo getDommagesSorts() {
        return dommagesSorts;
    }

    public void setDommagesSorts(FromTo dommagesSorts) {
        this.dommagesSorts = dommagesSorts;
    }

    public FromTo getPods() {
        return pods;
    }

    public void setPods(FromTo pods) {
        this.pods = pods;
    }

    public FromTo getResistanceFixeNeutre() {
        return resistanceFixeNeutre;
    }

    public void setResistanceFixeNeutre(FromTo resistanceFixeNeutre) {
        this.resistanceFixeNeutre = resistanceFixeNeutre;
    }
}
