package Fichier;

public class Utilisateur
{
    private int id;
    private String nom, prenom,login,mdp;
    public Utilisateur(int id,String nom, String prenom, String login, String mdp) {
        setId(id);
        setNom(nom);
        setPrenom(prenom);
        setLogin(login);
        setMdp(mdp);
    }
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getNom()
    {
        return nom;
    }
    public void setNom(String nom)
    {
        this.nom = nom;
    }
    public String getPrenom()
    {
        return prenom;
    }
    public void setPrenom(String prenom)
    {
        this.prenom = prenom;
    }
    public String getLogin()
    {
        return login;
    }
    public void setLogin(String login)
    {
        this.login = login;
    }
    public String getMdp()
    {
        return mdp;
    }
    public void setMdp(String mdp)
    {
        this.mdp = mdp;
    }
    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (!(obj instanceof Utilisateur))
            return false;
        Utilisateur u = (Utilisateur) obj;
        return u.id == this.id;
    }

}
