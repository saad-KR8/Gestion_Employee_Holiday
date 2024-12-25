package Model;

import java.util.List;

import DAO.EmployeeDAOImpl;
import View.EmployeeView;

public class EmployeeModel {
    private EmployeeDAOImpl dao;
    public EmployeeModel(EmployeeDAOImpl dao) {
        this.dao = dao;
    }

    public void ajouterEmployee(String nom, String prenom, String salaire, String email, String phone, Role role, Poste poste) {
        double salaireDouble = parseDouble(salaire);
        if(nom.trim().isEmpty() || prenom.trim().isEmpty() || email.trim().isEmpty() || phone.trim().isEmpty() || salaireDouble == 0) {
            EmployeeView.ajouterFail("Veuillez remplir tous les champs.");
            return;
        }

        if(!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            EmployeeView.ajouterFail("Veuillez entrer une adresse email valide.");
            return;
        }
        
        if(!phone.matches("^0\\d{9}$")) {
            EmployeeView.ajouterFail("Le numéro de téléphone doit contenir 10 chiffres");
            return;
        }
        
        if(parseDouble(salaire) <= 0 ){
            EmployeeView.ajouterFail("Le salaire doit être superieure de 0");
            return;
        }
        
        Employee employee = new Employee(0, nom, prenom, salaireDouble, email, phone, role, poste,25);
        dao.ajouter(employee);
    }
    public List<Employee> afficherEmployee() {
        return dao.afficher();
    }

    public void supprimerEmployee(int id) {
        if(EmployeeView.supprimerConfirmation()){
            dao.supprimer(id);
        }
        return;
    }
    public Employee findById(int id) {
        return dao.findById(id);
    }

    public void updateEmployee(Employee employee,int id,String nom,String prenom,String email,double salaire,String phone,Role role,Poste poste) {
        if(nom.trim().isEmpty() && prenom.trim().isEmpty() && email.trim().isEmpty() && phone.trim().isEmpty() && salaire == 0 && role == null && poste == null) {
            EmployeeView.modifierFail("Veuillez remplir au moins un champ.");
            return;
        }            
        if(!nom.trim().isEmpty()) employee.setNom(nom);
        if(!prenom.trim().isEmpty()) employee.setPrenom(prenom);
        if(!email.trim().isEmpty()){
            if(!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
                EmployeeView.modifierFail("Veuillez entrer une adresse email valide.");
                return;
            }
            employee.setEmail(email);
        }
        if(salaire != 0) {
            if(salaire <= 0 ){
                EmployeeView.modifierFail("Le salaire doit être superieure de 0");
                return;
            }
            employee.setSalaire(salaire);
        };
        if(!phone.isEmpty()){
            if(!phone.matches("^0\\d{9}$")) {
                EmployeeView.modifierFail("Le numéro de téléphone doit contenir 10 chiffres");
                return;
            }
            employee.setPhone(phone);
        } 
        if(role != null) employee.setRole(role);
        if(poste != null) employee.setPoste(poste);
        dao.modifier(employee,id);
    }

    public static double parseDouble(String s, double defaultValue) {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
    public static double parseDouble(String s) {
        return parseDouble(s, 0);
    }
}