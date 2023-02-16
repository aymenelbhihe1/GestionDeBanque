package Graphique;

import Fichier.ServiceClient;
import presentation.modele.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm extends JFrame{
    private JPanel panelConnexion, panelInputs, panelButtons;
    private JLabel labelConnexion,labelUsername,labelPassword;
    private JTextField textFieldUsername;
    private JPasswordField passwordField;
    private JButton buttonConnexion, buttonAnnuler, buttonInscription;
    private void initPanel()
    {
        panelConnexion = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelInputs = new JPanel(new GridLayout(2, 2, 5, 5));
        panelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelConnexion.add(labelConnexion);
        panelInputs.add(labelUsername);
        panelInputs.add(textFieldUsername);
        panelInputs.add(labelPassword);
        panelInputs.add(passwordField);
        panelButtons.add(buttonConnexion);
        panelButtons.add(buttonInscription);
        panelButtons.add(buttonAnnuler);
        panelConnexion.setBackground(new Color(0x6096B4));
        panelInputs.setBackground(new Color(0x6096B4));
        panelButtons.setBackground(new Color(0x6096B4));
        add(panelConnexion, BorderLayout.NORTH);
        add(panelInputs, BorderLayout.CENTER);
        add(panelButtons, BorderLayout.SOUTH);
    }
    private void initLabelTextFP()
    {
        labelConnexion = new JLabel("C O N N E X I O N ");
        labelUsername = new JLabel("      Nom d'utilisateur:");
        labelPassword = new JLabel("      Mot de passe:");
        textFieldUsername = new JTextField();
        passwordField = new JPasswordField();
    }
    private void initButton()
    {
        buttonConnexion = new JButton("Connexion");
        buttonAnnuler = new JButton("Quitter");
        buttonInscription = new JButton("Inscription");
        buttonConnexion.setBackground(new Color(0x609EA2));
        buttonAnnuler.setBackground(new Color(0xC92C6D));
        buttonInscription.setBackground(new Color(0x609EA2));
        buttonConnexion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textFieldUsername.getText();
                String password = passwordField.getText();
                ServiceClient sc = new ServiceClient();
                if(sc.login(username, password))
                {
                    dispose();
                    new ClientTable();
                }
                if(username.equals("admin") && password.equals("1234"))
                {
                    dispose();
                    Admin admin = Admin.getInstance();
                    new AdminMenuExample(admin.getNomComplet());
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Nom d'utilisateur ou mot de passe incorrect", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttonAnnuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        buttonInscription.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new SigninForm();
            }
        });
    }
    public LoginForm() {
        // Initialisation des composants
        initLabelTextFP();
        initButton();
        initPanel();
        // Création de la fenêtre
        setTitle("Connexion");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setBackground(new Color(0xF0EEED));
        setLocation(490,300);
        setSize(400, 125);
        setVisible(true);
    }
}
