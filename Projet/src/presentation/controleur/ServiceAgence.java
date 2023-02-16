package presentation.controleur;

import Fichier.FilesManager;
import presentation.modele.Banque;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class ServiceAgence implements FilesManager<Banque>
{
    private String entete="ID\t\t\t\tNom\t\t\t\tAdresse\t\t\t\tTelephone\t\t\t\tEmail";
    private String fileName = "Agences.txt";
    public int IDCount()
    {
        return FindAll().size();
    }
    public String getEntete()
    {
        return entete;
    }
    private ArrayList<Banque> banques=FindAll();
    @Override
    public void Save(Banque data) {
        banques.add(data);
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
    public void SaveAll(Banque[] data) {
        try
        {
            FileWriter fw = new FileWriter(fileName);
            fw.write(entete+"\n");
            for (int i = 0; i < data.length; i++)
            {
                Banque a = data[i];
                fw.write(a.toString()+"\n");
            }
            fw.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public Banque Find(int id) {
        for (Banque banque : FindAll()) {
            if (banque.getIdBanque() == id) {
                return banque;
            }
        }
        return null;
    }
    @Override
    public ArrayList<Banque> FindAll() {
        String line;
        String[] columns;
        ArrayList<Banque> banques = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                columns = line.split("\t\t\t\t");
                int id = Integer.parseInt(columns[0]);
                String nom = columns[1];
                String adresse = columns[2];
                String telephone = columns[3];
                String email = columns[4];
                banques.add(new Banque(id, nom,telephone, adresse,email));
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return banques;
    }
    @Override
    public void Delete(int id) {
        Banque banque = Find(id); // Chercher le client à supprimer
        if (banque != null)
        { // Si le client a été trouvé
            banques.remove(banque); // Le supprimer de la liste
        }
    }
    @Override
    public void DeleteAll() {
        banques.clear();
    }
    public ArrayList<Banque> trierParNom() {
        ArrayList<Banque> agences = new ArrayList<>();
        agences = FindAll();
        Collections.sort(agences, new Comparator<Banque>() {
            @Override
            public int compare(Banque b1, Banque b2) {
                return b1.getNomBanque().compareTo(b2.getNomBanque());
            }
        });
        return agences;
    }
    //methode pour trier par email
    public ArrayList<Banque> trierParEmail() {
        ArrayList<Banque> banque = new ArrayList<>();
        banques = FindAll();
        Collections.sort(banque, new Comparator<Banque>() {
            @Override
            public int compare(Banque o1, Banque o2) {
                return o1.getEmailBanque().compareTo(o2.getEmailBanque());
            }
        });
        return banques;
    }

}
