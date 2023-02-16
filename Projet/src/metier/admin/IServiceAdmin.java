package metier.admin;

import presentation.modele.Client;
import presentation.modele.Compte;
import presentation.modele.TableauDeBord;

import java.time.LocalDateTime;
import java.util.List;

public interface IServiceAdmin {

    // Gestion des clients :
    // --------------------
    // 1. Créer un client
    Client          nouveauClient();
    // 2. Créer un compte pour un client existant
    Client nouveauCompteClientExistant();

    // 3. Chercher un client par son Id
    Client chercherClientParId(int id);
    // 4. Chercher un client par son nom
    List<Client> chercherClientParNom(String nom);
    // 5. Chercher un client par son prénom
    List<Client> chercherClientParPrénom(String prenom);
    // 6. Chercher un client par son nom et son prénom
    Client chercherClientParCin(String cin);
    // 7. Chercher un client par son Email
    Client chercherClientParEmail(String email);

    // 8. Chercher un compte par son Id
    Compte chercherCompteParId(String idCompte);

    // 9. Chercher un compte par son Solde
    List<Compte>    chercherCompteParSolde(double solde);
    // 10. Chercher un compte par sa date de création
    List<Compte>    chercherCompteParDateCreation(LocalDateTime date);
    // 11. Chercher un compte par son Propriétaire
    List<Compte>    chercherCompteParPropriétaire(Client propriétaire);

    // 12. Modifier un client
    Client modifierClient(String filtre);
    // 13. Supprimer un compte
    boolean supprimerClient(int id);

    // 14. Calculer et afficher les statistiques

    // Tri des clients :
    // -----------------
    // 15. Tri des clients par Nom
    List<Client>    trierClientParNom();
    // 16. Tri des clients par Cin
    List<Client>    trierClientParCin();
    // 17. Tri des clients par Email
    List<Client>    trierClientParEmail();
    // 18. Tri des clients par Adresse
    List<Client>    trierClientParAdresse();
    // 19. Tri des clients par Solde du compte
    List<Client>    trierClientParSoldeCompte();


    // Tri des comptes :
    // -----------------
    // 20. Tri des comptes par Solde
    List<Compte>    trierComptesParSolde();
    // 21. Tri des comptes par Date de création
    List<Compte>    trierComptesParDateDeCreation();
    // 22. Tri des comptes par Propriétaire
    List<Compte>    trierComptesParNomPropriétaire();

}
