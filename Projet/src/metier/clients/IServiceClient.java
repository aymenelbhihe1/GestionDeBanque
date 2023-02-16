package metier.clients;

import presentation.modele.Compte;

import java.util.Scanner;

public interface IServiceClient
{
    boolean versement(Scanner clavier);

    boolean retrait  (Scanner clavier);

    boolean retrait  (int choixRetrait);
    boolean virement (Compte compte1, Compte compte2, double montant);
    boolean modifierProfile(int choixModification);
    void dernièresOpérations();
    Double afficherSolde();
    Compte choisirCompte();
}
