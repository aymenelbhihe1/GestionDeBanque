package Graphique;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Fichier.ServiceClient;
import presentation.modele.Client;

public class ClientTable extends JFrame {
    private ServiceClient sc = new ServiceClient();
    private final ArrayList<Client> clients = sc.FindAll();
    private DefaultTableModel model = new DefaultTableModel();
    private JPanel panel = new JPanel();
    private JComboBox<String> sortComboBox;
    JButton btnRestaurer ;
    JLabel labelTrierPar;
    private void initPanel() {
        String[] sortOptions = {"NOM", "PRENOM","ADRESSE","CIN"};
        sortComboBox = new JComboBox<String>(sortOptions);
        btnRestaurer = new JButton("Restaurer");
        labelTrierPar = new JLabel("Trier par:");
        panel.add(labelTrierPar);
        panel.add(sortComboBox);
        panel.add(btnRestaurer);
        add(panel, BorderLayout.NORTH);
    }
    private void setRows(ArrayList<Client> clients){
        for (Client tableLine : clients) {
            String line = tableLine.toString().trim();
            String[] dataRow = line.split("\t\t\t\t");
            model.addRow(dataRow);
        }
    }
    private void iniButton() {
        sortComboBox.addActionListener(e -> {
            String sortOption = (String) sortComboBox.getSelectedItem();
            model.setRowCount(0);
           switch (sortOption) {
                case "NOM":
                    setRows(sc.trierParNom());
                    break;
                case "PRENOM":
                    setRows(sc.trierParPrenom());
                    break;
                case "ADRESSE":
                    setRows(sc.trierParAdresse());
                    break;
                case "CIN":
                    setRows(sc.trierParCIN());
                    break;
            }
        });
        btnRestaurer.addActionListener(e -> {
            model.setRowCount(0);
            initTable();
        });
    }
    private void initTable() {
        String[] columnNames = {"ID", "NOM", "PRENOM", "LOGIN", "MDP", "ADRESSE", "TELEPHONE", "CIN", "SEXE"};
        model.setColumnIdentifiers(columnNames);
            try {
                BufferedReader br = new BufferedReader(new FileReader("Clients.txt"));
                String line;
                br.readLine();
                while ((line = br.readLine()) != null) {
                    String[] dataRow = line.split("\t\t\t\t");
                    model.addRow(dataRow);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }
    public ClientTable() {
        initTable();
        initPanel();
        iniButton();
        setTitle("Liste des clients");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
