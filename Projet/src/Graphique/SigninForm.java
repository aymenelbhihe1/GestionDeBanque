package Graphique;


import Fichier.ServiceClient;
import presentation.modele.Client;
import presentation.modele.Sexe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SigninForm extends JFrame{
        private JFrame frame;
        private JPanel panelTitle, panelInputs, panelButtons;
        private JLabel labelTitle, labelPrenom,labelNom,labelAddress, labelEmail,labelCin, labelTelephone,labelLogin, labelMotDePasse,labelSexe;
        private JTextField textFieldPrenom,textFieldNom,textFieldAddress,textFieldEmail,textFieldCin,textFieldTelephone,textFieldLogin;
        private JPasswordField passwordField;
        private JComboBox comboBoxSexe;
        private JButton buttonEnregistrer,buttonAnnuler,buttonSeConnecter;
        private void initPanel() {
            panelTitle = new JPanel(new FlowLayout(FlowLayout.CENTER));
            panelInputs = new JPanel(new GridLayout(9, 2, 10, 10));
            panelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
            // ajout des composants au panelTitle
            panelTitle.add(labelTitle);
            // ajout des composants au panelInputs
            panelInputs.add(labelPrenom);
            panelInputs.add(textFieldPrenom);
            panelInputs.add(labelNom);
            panelInputs.add(textFieldNom);
            panelInputs.add(labelAddress);
            panelInputs.add(textFieldAddress);
            panelInputs.add(labelEmail);
            panelInputs.add(textFieldEmail);
            panelInputs.add(labelCin);
            panelInputs.add(textFieldCin);
            panelInputs.add(labelTelephone);
            panelInputs.add(textFieldTelephone);
            panelInputs.add(labelLogin);
            panelInputs.add(textFieldLogin);
            panelInputs.add(labelMotDePasse);
            panelInputs.add(passwordField);
            panelInputs.add(labelSexe);
            panelInputs.add(comboBoxSexe);
            // ajout des composants au panelButtons
            panelButtons.add(buttonEnregistrer);
            panelButtons.add(buttonSeConnecter);
            panelButtons.add(buttonAnnuler);
            panelInputs.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            panelInputs.setBackground(new Color(0x6096B4));
            panelButtons.setBackground(new Color(0x6096B4));
            panelTitle.setBackground(new Color(0x6096B4));
            add(panelTitle, BorderLayout.NORTH);
            add(panelInputs, BorderLayout.CENTER);
            add(panelButtons, BorderLayout.SOUTH);
        }
        private void initLabelTextFP() {
            labelTitle = new JLabel("S ' I N S C R I R E");
            labelPrenom = new JLabel("         Prénom :");
            labelNom = new JLabel("         Nom :");
            labelAddress = new JLabel("         Adresse :");
            labelEmail = new JLabel("         E-mail :");
            labelCin = new JLabel("         CIN :");
            labelTelephone = new JLabel("         Téléphone :");
            labelLogin = new JLabel("         Login :");
            labelMotDePasse = new JLabel("         Mot de passe :");
            labelSexe = new JLabel("         Sexe :");
            textFieldPrenom = new JTextField();
            textFieldNom = new JTextField();
            textFieldAddress = new JTextField();
            textFieldEmail = new JTextField();
            textFieldCin = new JTextField();
            textFieldTelephone = new JTextField();
            textFieldLogin = new JTextField();
            passwordField = new JPasswordField();
            comboBoxSexe = new JComboBox(Sexe.values());
        }
        private void initButton() {
            buttonEnregistrer = new JButton("Enregistrer");
            buttonAnnuler = new JButton("Quitter");
            buttonSeConnecter = new JButton("Se connecter");
            buttonEnregistrer.setBackground(new Color(0x609EA2));
            buttonAnnuler.setBackground(new Color(0xC92C6D));
            buttonSeConnecter.setBackground(new Color(0x609EA2));
            buttonEnregistrer.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ServiceClient sc = new ServiceClient();
                    // verification des champs
                    if(textFieldPrenom.getText().isEmpty() || textFieldNom.getText().isEmpty() || textFieldAddress.getText().isEmpty() || textFieldEmail.getText().isEmpty() || textFieldCin.getText().isEmpty() || textFieldTelephone.getText().isEmpty() || textFieldLogin.getText().isEmpty() || passwordField.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs", "Erreur", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    else{
                        // Création d'un client
                       try {
                           Client c = null;
                           if (comboBoxSexe.getSelectedItem().toString().equals("HOMME")) {
                                c = new Client(sc.getIdCount()+1, textFieldPrenom.getText(), textFieldNom.getText(), textFieldAddress.getText(), textFieldEmail.getText(), textFieldCin.getText(), textFieldTelephone.getText(), textFieldLogin.getText(), passwordField.getText(), Sexe.HOMME);
                           }
                           else if (comboBoxSexe.getSelectedItem().toString().equals("FEMME")) {
                               c = new Client(sc.getIdCount()+1, textFieldPrenom.getText(), textFieldNom.getText(), textFieldAddress.getText(), textFieldEmail.getText(), textFieldCin.getText(), textFieldTelephone.getText(), textFieldLogin.getText(), passwordField.getText(), Sexe.FEMME);
                           }
                           sc.Save(c);
                           JOptionPane.showMessageDialog(null, "Client ajouté avec succès", "Succès", JOptionPane.INFORMATION_MESSAGE);
                           dispose();
                           new LoginForm();
                       }
                          catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Erreur d'ajout", "Erreur", JOptionPane.ERROR_MESSAGE);
                          }
                    }

                }
            });
            buttonAnnuler.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                }
            });
            buttonSeConnecter.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new LoginForm();
                }
            });
        }
        public SigninForm() {
            // Initialisation des composants
            initLabelTextFP();
            initButton();
            initPanel();
            // Création de la fenêtre
            setTitle("Sign in");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //mettre au centre
            setLocation(500, 200);
            setSize(400, 400);
            setUndecorated(true);
            setResizable(false);
            setVisible(true);
            }
    public static void main(String[] args) {
        new SigninForm();
    }
}
