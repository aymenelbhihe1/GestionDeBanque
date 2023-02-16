package presentation.controleur;

import Fichier.FilesManager;
import presentation.modele.Client;
import presentation.modele.Compte;
import presentation.modele.Sexe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class ServiceCompte implements FilesManager<Compte> {
    private static ArrayList<Compte> comptes;
    private String fileName = "Comptes.txt";
    public String getEntete()
    {
        String entete ="N°Compte\t\t\t\tSolde\t\t\t\tDate Création\t\t\t\tNom Propriétaire";
        return entete;
    }
    public ServiceCompte()
    {
        comptes = FindAll();
    }
    public int getIdCount()
    {
        return comptes.size();
    }
    @Override
    public void Save(Compte data) {
        comptes.add(data);
        try
        {
            FileWriter fw = new FileWriter(fileName, true);
            fw.write(data.toString()+"\n");
            fw.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void SaveAll(Compte[] data) {
        try
        {
            FileWriter fw = new FileWriter(fileName);
            fw.write(getEntete()+"\n");
            for (int i = 0; i < data.length; i++)
            {
                Compte c = data[i];
                fw.write(c.toString()+"\n");
            }
            fw.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public Compte Find(int id) {
        for (Compte compte : FindAll()) {
            /*if (compte.getNumeroCompte() == id) {
                return compte;
            }*/
        }
        return null;
    }
    @Override
    public ArrayList<Compte> FindAll() {
        String line;
        String[] columns;
        ArrayList<Client> clients = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                columns = line.split("\t\t\t\t");
                int nCompte = Integer.parseInt(columns[0]);
                int solde = Integer.parseInt(columns[1]);
                String dateCreation = columns[2];
                String nomProprietaire = columns[3];
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return comptes;
    }
    @Override
    public void Delete(int id) {
        Compte compte = Find(id); // Chercher le client à supprimer
        if (compte != null)
        { // Si le client a été trouvé
            comptes.remove(compte); // Le supprimer de la liste
        }
    }
    @Override
    public void DeleteAll() {
        comptes.clear();
    }
}
