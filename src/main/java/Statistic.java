import com.google.gson.annotations.SerializedName;

public class Statistic {
    @SerializedName("Vitalité")
    private FromTo vitalite;
    @SerializedName("Sagesse")
    private FromTo sagesse;
    @SerializedName("Soins")
    private FromTo soins;
    @SerializedName("% Critique")
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
    @SerializedName("Dommages Critiques")
    private FromTo dommagesCritiques;
    @SerializedName("% Résistance Neutre")
    private FromTo pourcentResistanceNeutre;
    @SerializedName("% Résistance Terre")
    private FromTo pourcentResistanceTerre;
    @SerializedName("% Résistance Feu")
    private FromTo pourcentResistanceFeu;
    @SerializedName("% Résistance Eau")
    private FromTo pourcentResistanceEau;
    @SerializedName("% Résistance Air")
    private FromTo pourcentResistanceAir;
    @SerializedName("Résistance Critiques")
    private FromTo resistanceCritiques;
    @SerializedName("Tacle")
    private FromTo tacle;

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
}
