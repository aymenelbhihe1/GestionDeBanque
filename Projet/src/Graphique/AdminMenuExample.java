package Graphique;
import Fichier.ServiceClient;
import presentation.controleur.ServiceAgence;
import presentation.modele.Banque;
import presentation.modele.Client;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.*;

public class AdminMenuExample extends JFrame{
    private JTable table;
    private JMenuBar menuBar;
    private JMenu menu1;
    private JMenuItem Client,Agences,Compte;
    private JPanel panelTable, panelNorth,panelLabel;
    private JLabel labelNomComplet;
    public AdminMenuExample(String NomComplet) {
        initialize(NomComplet);
    }
    private void initButtons(String NomComplet) {
        //initialisation des label
        labelNomComplet = new JLabel("Bienvenue Admin : "+NomComplet);
        labelNomComplet.setSize(new Dimension(100, 100));
    }
    private void initMenuBar() {
        menuBar = new JMenuBar();
        //initialisation du menu 1
        menu1 = new JMenu("Service Admin");
        Client = new JMenuItem("Client");
        Agences = new JMenuItem("Agences");
        Compte = new JMenuItem("Compte");
        menu1.add(Client);
        menu1.add(Agences);
        menu1.add(Compte);
        //ajout des menus dans la barre de menu
        menuBar.add(menu1);
        setJMenuBar(menuBar);
        Client.addActionListener(e -> {
            String[] columnNames = new ServiceClient().getEntete().split("\t\t\t\t");
            ArrayList<Client> clients = new ServiceClient().FindAll();
            TableFactory<Client> tableFactory = new TableFactory<>(columnNames,clients);
            //clear panel
            panelTable.removeAll();
            //add table to panel
            panelTable.add(tableFactory.scrollPane, BorderLayout.CENTER);
            panelTable.revalidate();
            panelTable.repaint();
        });
        Agences.addActionListener(e -> {
            String[] columnNames = new ServiceAgence().getEntete().split("\t\t\t\t");
            ArrayList<Banque> agences = new ServiceAgence().FindAll();
            TableFactory<Banque> tableFactory = new TableFactory<>(columnNames,agences);
            //clear panel
            panelTable.removeAll();
            //add table to panel
            panelTable.add(tableFactory.scrollPane, BorderLayout.CENTER);
            panelTable.revalidate();
            panelTable.repaint();
        });
        Compte.addActionListener(e -> {
            //new CompteTable();
        });
    }
    private void initPanelButtons() {
        //initialisation des panels
        panelNorth = new JPanel();
        panelLabel = new JPanel();
        panelTable = new JPanel();
        panelTable.setSize(new Dimension(750, 550));
        //initialisation du menu
        //panelButtons.add(menuBar);
        panelLabel.add(labelNomComplet);

        panelNorth.setLayout(new FlowLayout());
        panelLabel.setLayout(new FlowLayout());
        panelTable.setLayout(new FlowLayout());

        getContentPane().add(panelNorth, BorderLayout.NORTH);
        getContentPane().add(panelLabel, BorderLayout.SOUTH);
    }
    private void initialize(String NomComplet) {
        setBounds(100, 100, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initButtons(NomComplet);
        initPanelButtons();
        initMenuBar();
        /*table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);*/
        // Add buttons to a panel


        // Add panel with buttons to the bottom of the frame
        getContentPane().add(panelTable, BorderLayout.CENTER);

        setVisible(true);
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminMenuExample window = new AdminMenuExample("HHHHH");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
