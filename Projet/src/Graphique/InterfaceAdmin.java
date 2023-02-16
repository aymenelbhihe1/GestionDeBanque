package Graphique;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class InterfaceAdmin extends JFrame{
    private JMenuBar menuBar;
    private JMenu menuAdmin;
    private JMenuItem menuItemCrud, menuItemTrier;
    private JTable table;
    private DefaultTableModel model;

    private void initMenu() {
        // Création du menu "Menu Admin"
        menuBar = new JMenuBar();
        menuAdmin = new JMenu("Menu Admin");

        // Création des éléments de menu "Service CRUD" et "Service Trier"
        menuItemCrud = new JMenuItem("Service CRUD");
        menuItemTrier = new JMenuItem("Service Trier");

        // Ajout des éléments de menu dans le menu "Menu Admin"
        menuAdmin.add(menuItemCrud);
        menuAdmin.add(menuItemTrier);

        // Ajout du menu "Menu Admin" dans la barre de menu
        menuBar.add(menuAdmin);
    }
    private void initTable(){
        table = new JTable();

    }
    public InterfaceAdmin() {
        // initialisation du menu "Menu Admin"
        initMenu();
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // Ajout de la barre de menu et de la JTable dans le JFrame
        setJMenuBar(menuBar);
        add(new JScrollPane(table));
        setVisible(true);
    }

    public static void main(String[] args) {
        InterfaceAdmin frame = new InterfaceAdmin();
    }
}
