package Fichier;

import presentation.modele.Client;
import presentation.modele.Sexe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ServiceClient implements FilesManager<Client>
{
    private static ArrayList<Client> clients;
    private String fileName = "Clients.txt";
    public String getEntete()
    {
        String entete ="ID\t\t\t\tNom\t\t\t\tPrenom\t\t\t\tLogin\t\t\t\tMdp\t\t\t\tEmail\t\t\t\tAdresse\t\t\t\tTelephone\t\t\t\tCIN\t\t\t\tSexe";
        return entete;
    }
    public ServiceClient()
    {
        clients = FindAll();
    }
    public int getIdCount()
    {
        return clients.size();
    }
    @Override
    public void Save(Client data) {
        clients.add(data);
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
    public void SaveAll(Client[] data) {
        try
        {
            FileWriter fw = new FileWriter(fileName);
            fw.write(getEntete()+"\n");
            for (int i = 0; i < data.length; i++)
            {
                Client c = data[i];
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
    public Client Find(int id) {
        for (Client client : FindAll()) {
            if (client.getId() == id) {
                return client;
            }
        }
        return null;
    }
    @Override
    public ArrayList<Client> FindAll() {
        String line;
        String[] columns;
        ArrayList<Client> clients = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                columns = line.split("\t\t\t\t");
                int id = Integer.parseInt(columns[0]);
                String nom = columns[1];
                String prenom = columns[2];
                String login = columns[3];
                String mdp = columns[4];
                String email = columns[5];
                String adresse = columns[6];
                String telephone = columns[7];
                String cin = columns[8];
                String sexe = columns[9];
                if (sexe.equals("HOMME"))
                    clients.add(new Client(id,nom, prenom, login, mdp,email, adresse, telephone, cin, Sexe.HOMME));
                else if (sexe.equals("FEMME"))
                {
                    clients.add(new Client(id,nom, prenom, login, mdp,email, adresse, telephone, cin, Sexe.FEMME));
                }
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return clients;
    }
    @Override
    public void Delete(int id) {
        Client client = Find(id); // Chercher le client à supprimer
        if (client != null)
        { // Si le client a été trouvé
            clients.remove(client); // Le supprimer de la liste
        }
    }
    @Override
    public void DeleteAll() {
        clients.clear();
    }
    public ArrayList<Client> trierParNom() {
     ArrayList<Client> clientsTries = clients;
        Collections.sort(clientsTries, new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                return o1.getNom().compareTo(o2.getNom());
            }
        });
        return clientsTries;
        }
    public ArrayList<Client> trierParPrenom() {
        ArrayList<Client> clientsTries = clients;
            Collections.sort(clientsTries, new Comparator<Client>() {
                @Override
                public int compare(Client o1, Client o2) {
                    return o1.getPrenom().compareTo(o2.getPrenom());
                }
            });
            return clientsTries;
            }
    public ArrayList<Client> trierParCIN() {
        ArrayList<Client> clientsTries = clients;
            Collections.sort(clientsTries, new Comparator<Client>() {
                @Override
                public int compare(Client o1, Client o2) {
                    return o1.getCin().compareTo(o2.getCin());
                }
            });
            return clientsTries;
    }
    public ArrayList<Client> trierParAdresse() {
        ArrayList<Client> clientsTries = clients;
            Collections.sort(clientsTries, new Comparator<Client>() {
                @Override
                public int compare(Client o1, Client o2) {
                    return o1.getAddress().compareTo(o2.getAddress());
                }
            });
            return clientsTries;
    }
    public boolean login(String login, String mdp) {
        for (Client client : clients) {
            if (client.getLogin().equals(login) && client.getMotDePasse().equals(mdp)) {
                return true;
            }
        }
        return false;
    }

}
