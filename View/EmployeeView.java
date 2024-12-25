package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Model.Employee;
import Model.Poste;
import Model.Role;
import java.awt.*;

public class EmployeeView extends JFrame {
    protected static final EmployeeView INSTANCE = new EmployeeView();
    protected JPanel mainPanel = new JPanel();
    protected JPanel upperPanel = new JPanel();
    protected JPanel lowerPanel = new JPanel();
    protected JPanel listContainerPanel = new JPanel();
    protected JPanel buttonsContainerPanel = new JPanel();
    protected DefaultTableModel tableModel = new DefaultTableModel(new String[]{"Id","Nom", "Prenom", "Email", "Salaire", "Phone", "Role", "Poste", "Holiday Balance"}, 0){};
    protected JTable employeeTable = new JTable(tableModel);
    protected JButton ajouterButton = new JButton("Ajouter");
    protected JButton modifierButton = new JButton("Modifier");
    protected JButton supprimerButton = new JButton("Supprimer");
    protected JButton afficherButton = new JButton("Afficher");
    protected JLabel nomLabel;
    protected JTextField nomField;
    protected JLabel prenomLabel;
    protected JTextField prenomField;
    protected JLabel emailLabel;
    protected JTextField emailField;
    protected JLabel telephoneLabel;
    protected JTextField telephoneField;
    protected JLabel salaireLabel;
    protected JTextField salaireField;
    protected JLabel roleLabel;
    protected JComboBox<Role> roleComboBox;
    protected JLabel posteLabel;
    protected JComboBox<Poste> posteComboBox;

    public EmployeeView() {
        setTitle("Gestion des employés");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(930, 520);
        setLocationRelativeTo(null);
        add(mainPanel);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(upperPanel, BorderLayout.NORTH);
        mainPanel.add(lowerPanel, BorderLayout.CENTER);
        upperPanel.setLayout(new GridLayout(7,2));
        upperPanel.setBorder(BorderFactory.createEmptyBorder(10, 18, 10, 18));
        nomLabel = new JLabel("Nom");
        nomField = new JTextField();
        upperPanel.add(nomLabel);
        upperPanel.add(nomField);
        prenomLabel = new JLabel("Prénom");
        prenomField = new JTextField();
        upperPanel.add(prenomLabel);
        upperPanel.add(prenomField);
        emailLabel = new JLabel("Email");
        emailField = new JTextField();
        upperPanel.add(emailLabel);
        upperPanel.add(emailField);
        telephoneLabel = new JLabel("Téléphone");
        telephoneField = new JTextField();
        upperPanel.add(telephoneLabel);
        upperPanel.add(telephoneField);
        salaireLabel = new JLabel("Salaire");
        salaireField = new JTextField();
        upperPanel.add(salaireLabel);
        upperPanel.add(salaireField);
        roleLabel = new JLabel("Role");
        roleComboBox = new JComboBox<>(Role.values());
        upperPanel.add(roleLabel);
        upperPanel.add(roleComboBox);
        posteLabel = new JLabel("Poste");
        posteComboBox = new JComboBox<>(Poste.values());
        upperPanel.add(posteLabel);
        upperPanel.add(posteComboBox);
        lowerPanel.setLayout(new BorderLayout());
        lowerPanel.add(listContainerPanel, BorderLayout.CENTER);
        listContainerPanel.setLayout(new FlowLayout());
        Dimension preferredSize = new Dimension(EmployeeView.this.getWidth() - 50,500);
        employeeTable.setPreferredScrollableViewportSize(preferredSize);
        employeeTable.setFillsViewportHeight(true);
        listContainerPanel.add(new JScrollPane(employeeTable));
        lowerPanel.add(buttonsContainerPanel, BorderLayout.SOUTH);
        buttonsContainerPanel.setLayout(new FlowLayout());
        buttonsContainerPanel.add(ajouterButton);
        buttonsContainerPanel.add(modifierButton);
        buttonsContainerPanel.add(supprimerButton);
        buttonsContainerPanel.add(afficherButton);
    }

    public static void ajouterSuccess(Employee employee){
        JOptionPane.showMessageDialog(null, "L'employé a été ajouté avec succès");
    }

    public static void ajouterFail(String message){
        JOptionPane.showMessageDialog(null, "L'employé n'a pas été ajouté. " + message);
    }

    public static void afficherFail(String message){
        JOptionPane.showMessageDialog(null, message);
    }

    public static void supprimerSuccess(){
        JOptionPane.showMessageDialog(null, "L'employé a bien éte supprimé.");
    }

    public static void supprimerFail(String message){
        JOptionPane.showMessageDialog(null, message);
    }

    public static void modifierSuccess(){
        JOptionPane.showMessageDialog(null, "L'employé a bien été modifié.");
    }

    public static void modifierFail(String message){
        JOptionPane.showMessageDialog(null, message);
    }

    public static boolean supprimerConfirmation(){
        int choice = JOptionPane.showOptionDialog(null, "Êtes-vous sûr de supprimer cet employé?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Oui", "Non"}, "Non");
        return choice == JOptionPane.YES_OPTION;
    }

    public JTable getTable() {
        return employeeTable;
    }

    public JButton getAjouterButton() {
        return ajouterButton;
    }

    public JButton getModifierButton() {
        return modifierButton;
    }

    public JButton getSupprimerButton() {
        return supprimerButton;
    }

    public JButton getAfficherButton() {
        return afficherButton;
    }

    public JTextField getNomField() {
        return nomField;
    }

    public JTextField getPrenomField() {
        return prenomField;
    }

    public JTextField getSalaireField() {
        return salaireField;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JTextField getPhoneField() {
        return telephoneField;
    }

    public JComboBox<Role> getRoleComboBox() {
        return roleComboBox;
    }

    public JComboBox<Poste> getPosteComboBox() {
        return posteComboBox;
    }

    public static EmployeeView getInstance() {
        return INSTANCE;
    }
}
