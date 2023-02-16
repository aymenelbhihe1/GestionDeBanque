package presentation.controleur;

import metier.admin.IServiceAdmin;
import presentation.modele.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class ServiceAdmin implements IServiceAdmin
{
    private Banque maBanque= new Banque();
    public ServiceAdmin(Banque maBanque)
    {
        this.maBanque = maBanque;
    }
    @Override
    public Client nouveauClient()
    {
        return null;
    }
    @Override
    public Client nouveauCompteClientExistant() {
        Scanner clavier = new Scanner(System.in);
        // cree un nouveau compte pour un client existant
        String nom, prenom, cin, email;
        System.out.print("Saisir le Solde : ");
        double solde = clavier.nextDouble();
        System.out.print("Saisir le CIN du client : ");
        cin = clavier.nextLine();
        Client client=chercherClientParCin(cin);
        if(client!=null)
        {
            Compte compte = new Compte(solde, client);
            return client;
        }
        else
        {
            System.out.println("Client introuvable");
            return null;
        }

    }
    @Override
    public Client chercherClientParId(int id) {
        for (Client client : maBanque.getClientsDeBanque()) {
            if (client.getId()==id)
            {
                return client;
            }
        }
        return null;
    }
    @Override
    public List<Client> chercherClientParNom(String nom) {
        List<Client> clients = new ArrayList<>();
        for (Client client : maBanque.getClientsDeBanque()) {
            if (client.getNom().equals(nom)) {
                clients.add(client);
            }
        }
        if (clients.isEmpty()) {
            return null;
        }
        return clients;
    }
    @Override
    public List<Client> chercherClientParPrénom(String prenom) {
        List<Client> clients = new ArrayList<>();
        for (Client client : maBanque.getClientsDeBanque()) {
            if (client.getPrenom().equals(prenom)) {
                clients.add(client);
            }
        }
        if (clients.isEmpty()) {
            return null;
        }
        return clients;
    }
    @Override
    public Client chercherClientParCin(String cin) {
        for (Client client : maBanque.getClientsDeBanque()) {
            if (client.getCin().equals(cin)) {
                return client;
            }
        }
        return null;
    }
    @Override
    public Client chercherClientParEmail(String email) {
        for (Client client : maBanque.getClientsDeBanque()) {
            if (client.getEmail().equals(email)) {
                return client;
            }
        }
        return null;
    }
    @Override
    public Compte chercherCompteParId(String idCompte) {
        List<Client> clients = maBanque.getClientsDeBanque();
        for (Client client : clients) {
            for (Compte compte : client.getComptesClient())
            {
                if (compte.getNumeroCompte().equals(idCompte)) {
                    return compte;
                }
            }
        }
        return null;
    }
    @Override
    public List<Compte> chercherCompteParSolde(double solde) {
        List<Compte> comptes = new ArrayList<>();
        List<Client> clients = maBanque.getClientsDeBanque();
        for (Client client : clients) {
            for (Compte compte : client.getComptesClient()) {
                if (compte.getSolde() == solde) {
                    comptes.add(compte);
                }
            }
        }
        if (comptes.isEmpty()) {
            return null;
        }
        return comptes;
    }
    @Override
    public List<Compte> chercherCompteParDateCreation(LocalDateTime date) {
        List<Compte> comptes = new ArrayList<>();
        List<Client> clients = maBanque.getClientsDeBanque();
        for (Client client : clients) {
            for (Compte compte : client.getComptesClient()) {
                if (compte.getDateCreation().equals(date)) {
                    comptes.add(compte);
                }
            }
        }
        return comptes;
    }
    @Override
    public List<Compte> chercherCompteParPropriétaire(Client propriétaire) {
        List<Compte> comptes = new ArrayList<>();
        List<Client> clients = maBanque.getClientsDeBanque();
        for (Client client : clients) {
            if (client.equals(propriétaire)) {
                comptes = client.getComptesClient();
            }
        }
        if (comptes.isEmpty()) {
            return null;
        }
        else {
            return comptes;
        }
    }
    @Override
    public Client modifierClient(String filtre) {
        return null;
    }
    @Override
    public boolean supprimerClient(int id) {
        Client client = chercherClientParId(id);
        if (client != null) {
            maBanque.getClientsDeBanque().remove(client);
            return true;
        }
        else {
            return false;
        }
    }

    //Client : trier
    @Override
    public List<Client> trierClientParNom() {
        List<Client> clients = maBanque.getClientsDeBanque();
        Collections.sort(clients, new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                return o1.getNom().compareTo(o2.getNom());
            }
        });
        return clients;
    }
    @Override
    public List<Client> trierClientParCin() {
        List<Client> clients = maBanque.getClientsDeBanque();
        Collections.sort(clients, new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                return o1.getCin().compareTo(o2.getCin());
            }
        });
        return clients;
    }
    @Override
    public List<Client> trierClientParEmail() {
        List<Client> clients = maBanque.getClientsDeBanque();
        Collections.sort(clients, new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                return o1.getEmail().compareTo(o2.getEmail());
            }
        });
        return clients;
    }
    @Override
    public List<Client> trierClientParAdresse() {
        List<Client> clients = maBanque.getClientsDeBanque();
        Collections.sort(clients, new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                return o1.getAddress().compareTo(o2.getAddress());
            }
        });
        return clients;
    }
    @Override
    public List<Client> trierClientParSoldeCompte() {
        //trier les clients par  leur solde de compte
        List<Compte> comptes = trierComptesParSolde();
        List<Client> clients = new ArrayList<>();
        for (Compte compte : comptes) {
            clients.add(compte.getPropriétaire());
        }
        return clients;
    }

    //Compte : Trier
    @Override
    public List<Compte> trierComptesParSolde() {
        List<Compte> comptes = new ArrayList<>();
        List<Client> clients = maBanque.getClientsDeBanque();
        for (Client client : clients) {
            for (Compte compte : client.getComptesClient())
            {
                comptes.add(compte);
            }
        }
        Collections.sort(comptes, new Comparator<Compte>() {
            @Override
            public int compare(Compte o1, Compte o2) {
                return o1.getSolde().compareTo(o2.getSolde());
            }
        });
        return comptes;
    }
    @Override
    public List<Compte> trierComptesParDateDeCreation() {
        List<Compte> comptes = new ArrayList<>();
        List<Client> clients = maBanque.getClientsDeBanque();
        for (Client client : clients) {
            for (Compte compte : client.getComptesClient())
            {
                comptes.add(compte);
            }
        }
        Collections.sort(comptes, new Comparator<Compte>() {
            @Override
            public int compare(Compte o1, Compte o2) {
                return o1.getDateCreation().compareTo(o2.getDateCreation());
            }
        });
        return comptes;
    }
    @Override
    public List<Compte> trierComptesParNomPropriétaire() {
        List<Compte> comptes = new ArrayList<>();
        List<Client> clients = maBanque.getClientsDeBanque();
        for (Client client : clients) {
            for (Compte compte : client.getComptesClient())
            {
                comptes.add(compte);
            }
        }
        Collections.sort(comptes, new Comparator<Compte>() {
            @Override
            public int compare(Compte o1, Compte o2) {
                return o1.getPropriétaire().getNom().compareTo(o2.getPropriétaire().getNom());
            }
        });
        return comptes;
    }

}
