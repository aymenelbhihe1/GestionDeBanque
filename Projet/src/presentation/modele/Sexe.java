package presentation.modele;

public enum Sexe {

    HOMME(0,"H", "Homme"),
    FEMME(1,"F", "Femme");
        String libelle, abreviation;
        Integer indice;
                Sexe(Integer indice, String abreviation, String libelle) {
                    this.indice = indice;
                    this.abreviation = abreviation;
                    this.libelle = libelle;
                }
    public Integer getIndice() {
        return indice;
    }
    public String getAbreviation() {
        return abreviation;
    }
    public String getLibelle() {
        return libelle;
    }
}
