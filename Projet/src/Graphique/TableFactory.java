package Graphique;

import Fichier.ServiceClient;
import presentation.modele.Client;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class TableFactory<T>{
    private DefaultTableModel model = new DefaultTableModel();
    private JTable table = new JTable(model);
    JScrollPane scrollPane=new JScrollPane(table);
    private void initTable(String[] columnNames,ArrayList<T> data) {
        model.setColumnIdentifiers(columnNames);
        for (Object tableLine : data) {
            String line = tableLine.toString().trim();
            String[] dataRow = line.split("\t\t\t\t");
            model.addRow(dataRow);
        }
    }
    public TableFactory(String[] columnNames, ArrayList<T> data) {
        initTable(columnNames,data);
    }
    public static void main(String[] args)
    {
        ServiceClient sc = new ServiceClient();
        ArrayList<Client> clients = sc.FindAll();
        String[] columnNames = {"ID","Nom","Prenom","Login","Mdp","Email","Adresse","Telephone","CIN","Sexe"};
        TableFactory<Client> tableFactory = new TableFactory<>(columnNames,clients);
        JFrame frame = new JFrame();
        frame.add(tableFactory.scrollPane);
        frame.setSize(1000, 500);
        frame.setVisible(true);
    }
}
