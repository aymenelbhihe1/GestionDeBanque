package presentation.modele;

public class TableauDeBord {
    private Integer    nombreTotaleClient;
    private Integer    nombreTotaleCompte;
    private Double  maxSolde;
    private Double  minSolde;
    private String  nomClientLePlusRiche;
    private Integer    totalClientsFemme, totaleClientsHomme;

    public Integer getNombreTotaleClient() {
        return nombreTotaleClient;
    }
    public Double getMaxSolde() {
        return maxSolde;
    }
    public Double getMinSolde() {
        return minSolde;
    }
    public Integer getNombreTotaleCompte() {
        return nombreTotaleCompte;
    }
    public Integer getTotalClientsFemme() {
        return totalClientsFemme;
    }
    public Integer getTotalClientsHomme() {
        return totaleClientsHomme;
    }
    public String getNomClientLePlusRiche() {
        return nomClientLePlusRiche;
    }

    public void setMaxSolde(Double maxSolde) {
        this.maxSolde = maxSolde;
    }
    public void setMinSolde(Double minSolde) {
        this.minSolde = minSolde;
    }
    public void setNombreTotaleClient(Integer nombreTotaleClient) {
        this.nombreTotaleClient = nombreTotaleClient;
    }
    public void setNombreTotaleCompte(Integer nombreTotaleCompte) {
        this.nombreTotaleCompte = nombreTotaleCompte;
    }
    public void setNomClientLePlusRiche(String nomClientLePlusRiche) {
        this.nomClientLePlusRiche = nomClientLePlusRiche;
    }
    public void setTotalClientsFemme(Integer totalClientsFemme) {
        this.totalClientsFemme = totalClientsFemme;
    }
    public void setTotalClientsHomme(Integer totaleClientsHomme) {
        this.totaleClientsHomme = totaleClientsHomme;
    }


    public TableauDeBord(){}

}

