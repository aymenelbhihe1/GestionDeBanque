package presentation.modele;

public class Utilisateur {
    private static int compteur = 1;
    private int id;
    protected String prenom, nom;
    protected String login, motDePasse, role;
    public int getId() {
        return id;
    }
    public void setId() {
        this.id = compteur++;
    }
    public String getNomComplet() {
        return prenom + " " + nom;
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getLogin() {
        return login;
    }
    public String getMotDePasse() {
        return motDePasse;
    }
    public String getRole() {
        return role;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public  Utilisateur(){setId();}

    public  Utilisateur(int id,String login, String pass, String role){
        this.id             = id;
        this.login          = login;
        this.motDePasse     = pass;
        this.role           = role;
    }


}
