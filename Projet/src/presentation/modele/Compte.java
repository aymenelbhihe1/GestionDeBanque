package presentation.modele;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Compte implements AffichageInfos, Comparable<Compte> {
    private static long          compteur = 1;
    private String          numeroCompte;
    private Double          solde;
    private LocalDateTime   dateCreation;
    private Client          propriétaire;
    private List<Log>       logs = new ArrayList<>();

    public void setDateCreation() { this.dateCreation = LocalDateTime.now(); }
    public void setPropriétaire(Client propriétaire) {
        this.propriétaire = propriétaire;
    }
    public void setSolde(Double solde) {
        this.solde = solde;
    }
    public void setLog(TypeLog type, String msg) {

        Log log = new Log(LocalDate.now(), LocalTime.now(), type, msg);
        logs.add(log);
    }

    public Client getPropriétaire() {
        return propriétaire;
    }
    public Double           getSolde() {
        return solde;
    }
    public String getNumeroCompte() {
        return numeroCompte;
    }
    public void setNumeroCompte() {
        this.numeroCompte = "b-co00" + compteur++;
    }
    public LocalDateTime    getDateCreation() {
        return dateCreation;
    }
    public List<Log>        getLogs() {
        return logs;
    }

    public Compte(int id,double solde){
        setNumeroCompte();
        setDateCreation();
        setSolde(solde);
        setPropriétaire(null);
    }
    public Compte(double solde){
        setNumeroCompte();
        setDateCreation();
        setSolde(solde);
        setPropriétaire(null);
    }
    public Compte(double solde, Client propriétaire){
        setNumeroCompte();
        setDateCreation();
        setSolde(solde);
        setPropriétaire(propriétaire);
    }

    @Override
    public String toString() {

        String s =getNumeroCompte()+"\t\t\t\t"+getSolde()+"\t\t\t\t"+getDateCreation()+"\t\t\t\t"+getPropriétaire();

        return s;
    }


    @Override
    public void afficherBref()
    {
        System.out.println("---------------------------------------------------------------");
        System.out.println("| N° de Compte : " + getNumeroCompte() + " | Solde : " + getSolde() + " Dh");
    }
    public void afficherLesLogs() {
        System.out.println("Les Logs du Compte N° " + getNumeroCompte() + " :");
        logs.forEach(log -> System.out.println(log));
    }

    @Override
    public void afficherInformations() {
        System.out.println(this);
    }

    @Override
    public void afficherInformationsDétaillées() {
        System.out.println(this);
        afficherLesLogs();
    }

    @Override
    public int compareTo(Compte cpt) {
        if (cpt.getSolde() > this.getSolde()) return -1;
        else if (cpt.getSolde() < this.getSolde()) return 1;
        else return 0;
    }


}
