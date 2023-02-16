package presentation.controleur;

import Fichier.FilesManager;
import metier.clients.IServiceClient;
import presentation.modele.Client;
import presentation.modele.Compte;
import presentation.modele.Log;
import presentation.modele.TypeLog;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;
public class ServiceCLient implements IServiceClient {
    private Compte compte;
    //Constructeur
    public ServiceCLient(Compte compte) {
        this.compte = compte;
    }
    public ServiceCLient() {
        this.compte = null;
    }
    //Setters
    public void setCompte(Compte compte) {
        this.compte = compte;
    }
    @Override
    public boolean versement(Scanner clavier) {
        double montantVerser = clavier.nextDouble();
        if (montantVerser > 0) {
            compte.setSolde(compte.getSolde() + montantVerser);
            compte.getLogs().add(new Log(LocalDate.now(), LocalTime.now(), TypeLog.VERSEMENT, "Versement de " + montantVerser + " DH"));
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean retrait(Scanner clavier) {
        double montantRetirer = clavier.nextDouble();
        if (montantRetirer > 0 && montantRetirer <= compte.getSolde()) {
            compte.setSolde(compte.getSolde() - montantRetirer);
            compte.getLogs().add(new Log(LocalDate.now(), LocalTime.now(), TypeLog.RETRAIT, "Retrait de " + montantRetirer + " DH"));
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean retrait(int choixRetrait) {
        switch (choixRetrait) {
            case 1:
                if (compte.getSolde() >= 100) {
                    compte.setSolde(compte.getSolde() - 100);
                    compte.getLogs().add(new Log(LocalDate.now(), LocalTime.now(), TypeLog.RETRAIT, "Retrait de 100 DH"));
                    return true;
                } else {
                    return false;
                }
            case 2:
                if (compte.getSolde() >= 200) {
                    compte.setSolde(compte.getSolde() - 200);
                    compte.getLogs().add(new Log(LocalDate.now(), LocalTime.now(), TypeLog.RETRAIT, "Retrait de 200 DH"));
                    return true;
                } else {
                    return false;
                }
            case 3:
                if (compte.getSolde() >= 500) {
                    compte.setSolde(compte.getSolde() - 500);
                    compte.getLogs().add(new Log(LocalDate.now(), LocalTime.now(), TypeLog.RETRAIT, "Retrait de 500 DH"));
                    return true;
                } else {
                    return false;
                }
            case 4:
                if (compte.getSolde() >= 1000) {
                    compte.setSolde(compte.getSolde() - 1000);
                    compte.getLogs().add(new Log(LocalDate.now(), LocalTime.now(), TypeLog.RETRAIT, "Retrait de 1000 DH"));
                    return true;
                } else {
                    return false;
                }
                case 5:
                if (compte.getSolde() >= 2000) {
                    compte.setSolde(compte.getSolde() - 2000);
                    compte.getLogs().add(new Log(LocalDate.now(), LocalTime.now(), TypeLog.RETRAIT, "Retrait de 2000 DH"));
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }
    @Override
    public boolean virement(Compte compte1, Compte compte2, double montant) {
        if (montant > 0 && montant <= compte1.getSolde()) {
            compte1.setSolde(compte1.getSolde() - montant);
            compte2.setSolde(compte2.getSolde() + montant);
            compte1.getLogs().add(new Log(LocalDate.now(), LocalTime.now(), TypeLog.VIREMENT, "Virement de " + montant + " DH vers le compte " + compte2.getNumeroCompte()));
            compte2.getLogs().add(new Log(LocalDate.now(), LocalTime.now(), TypeLog.VIREMENT, "Virement de " + montant + " DH depuis le compte " + compte1.getNumeroCompte()));
            return true;
        } else {
            return false;
        }

    }
    @Override
    public boolean modifierProfile(int choixModification) {
        return false;
    }
    @Override
    public void dernièresOpérations() {

        //verifier si le log supérieur à 10
        if (compte.getLogs().size() > 3) {
            for (int i = compte.getLogs().size() - 1; i > 4; i--) {
                System.out.println(compte.getLogs().get(i).toString());
            }
        } else {
            for (int i = compte.getLogs().size() - 1; i >= 0; i--) {
                System.out.println(compte.getLogs().get(i).toString());
            }
        }
    }
    @Override
    public Double afficherSolde()
    {
        return compte.getSolde();
    }
    @Override
    public Compte choisirCompte() {
       return null;
    }

}
