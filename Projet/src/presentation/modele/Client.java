package presentation.modele;

import Fichier.ServiceClient;

import java.util.*;


public class Client extends Utilisateur implements AffichageInfos,Comparable<Client> {

    private String email, cin, tel,address;
    private Sexe sexe;
    private List<Compte> comptesClient;
    private Double soldeTotal ;
    public String       getCin() {
        return cin;
    }
    public String       getTel() {
        return tel;
    }
    public String       getEmail() {
        return email;
    }
    public List<Compte> getComptesClient() {
        return comptesClient;
    }
    public String       getAddress() {return address;}
    public Sexe getSexe() {
        return sexe;
    }
    public Double getSoldeTotal() {
        for (Compte compte : comptesClient) {
            soldeTotal += compte.getSolde();
        }
        return soldeTotal;
    }
    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public void setCin(String cin) {
        this.cin = cin;
    }
    public void setAddress(String address) {this.address = address;}
    public void setComptesClient(Compte comptesClient) {
        this.comptesClient.add(comptesClient);
    }
    public Client(){

        comptesClient = new ArrayList<>();
    }
    public Client(int id,String login, String pass){
        super(id,login, pass, "Client");
        comptesClient = new ArrayList<Compte>();
    }
    public Client(int id,String login, String pass, String n, String p){
        super(id,login, pass, "Client");
        setNom(n);
        setPrenom(p);
        comptesClient = new ArrayList<Compte>();
    }
    public Client(int id,String n, String p,String login, String pass,  String mail, String adresse, String tel,String cin, Sexe sexe){
        super(id,login, pass, "Client");
        setNom(n);
        setPrenom(p);
        setTel(tel);
        setEmail(mail);
        setCin(cin);
        setAddress(adresse);
        setSexe(sexe);
        comptesClient = new ArrayList<Compte>();
    }
    @Override
    public String toString() {
                    //ID	           Nom	               Prenom				   Login				  Mdp			            Email	              Adresse			Telephone				 CIN				  Sexe
        String s = getId()+"\t\t\t\t"+getNom()+"\t\t\t\t"+getPrenom()+"\t\t\t\t"+getLogin()+"\t\t\t\t"+getMotDePasse()+"\t\t\t\t"+getEmail()+"\t\t\t\t"+getAddress()+"\t\t\t\t"+getTel()+"\t\t\t\t"+getCin()+"\t\t\t\t"+getSexe();
        return s;
    }
    @Override
    public void afficherBref() {
        String      clientStr  = "------------------------------------------------------\n";
                    clientStr += "| Identifiant du Client     : "   + this.getId()        + "\n";
                    clientStr += "| Nom Complet               : "   + this.getNomComplet() + "\n" ;
                    clientStr += "------------------------------------------------------\n";
        System.out.println(clientStr);
    }
    @Override
    public void afficherInformations()
    {
        System.out.println(this);
    }
    @Override
    public void afficherInformationsDétaillées() {
        System.out.println(this);
        System.out.println("Les Comptes du Client :");
        for (Compte compte : comptesClient)
        {
            compte.afficherInformations();
        }
    }

    @Override
    public int compareTo(Client clt) {
        return (int)(getId()-clt.getId());
    }
    public static void Main(String[] args){

    }
}
