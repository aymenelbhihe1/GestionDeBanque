package presentation.modele;

import presentation.controleur.ServiceAgence;

import java.util.*;

public class Banque implements AffichageInfos {

    private static int          compteur = 1;
    private Integer                 idBanque;
    private String              nomBanque;
    private String              adresseBanque;
    private String              telBanque;
    private String              emailBanque;
    private List<Client>        clientsDeBanque = new ArrayList<>();
    public Banque()
                    {
                        idBanque = compteur++;
                    }
    public Banque(int id,String nom, String tel, String adresse, String mail) {
                        idBanque        = id;
                        nomBanque       = nom;
                        telBanque       = tel;
                        adresseBanque   = adresse;
                        emailBanque     = mail;
    }
    public int             getIdBanque() {
        return idBanque;
    }
    public String           getNomBanque() {
        return nomBanque;
    }
    public String           getEmailBanque() {
        return emailBanque;
    }
    public String           getTelBanque() {
        return telBanque;
    }
    public String           getAdresseBanque() {
        return adresseBanque;
    }
    public List<Client>     getClientsDeBanque() {
        return clientsDeBanque;
    }
    public void             setIdBanque(int idBanque) {
        this.idBanque = idBanque;
    }
    public void             setNomBanque(String nomBanque) {
        this.nomBanque = nomBanque;
    }
    public void             setEmailBanque(String emailBanque) {
        this.emailBanque = emailBanque;
    }
    public void             setAdresseBanque(String adresseBanque) {
        this.adresseBanque = adresseBanque;
    }
    public void             setTelBanque(String telBanque) {
        this.telBanque = telBanque;
    }
    public void             setClientsDeBanque(Client clientsDeBanque) {
        this.clientsDeBanque.add(clientsDeBanque);
    }

    //toString
    @Override
    public String toString() {
        String s =getIdBanque()+"\t\t\t\t"+getNomBanque()+"\t\t\t\t"+getAdresseBanque()+"\t\t\t\t"+getTelBanque()+"\t\t\t\t"+getEmailBanque();
        return s;
    }

    @Override
    public void afficherBref() {
        System.out.println("------------------------------------------------------");
        System.out.println("| Identifiant de Banque     : "   + getIdBanque());
        System.out.println("| Nom de Banque             : "   + getNomBanque());
        System.out.println("------------------------------------------------------");
    }
    @Override
    public void afficherInformations() {
        System.out.println(this);
    }
    @Override
    public void afficherInformationsDétaillées() {
        System.out.println(this);
        System.out.println("Liste des Clients de la Banque : ");
        for (Client client : clientsDeBanque) {
            client.afficherInformations();
        }
    }
}
