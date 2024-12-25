package DAO;

import java.util.List;

import Model.Employee;

public interface GeneriqueDAOI<T> {
     List<T> afficher();
     void ajouter(T t);
     void modifier(T t,int id);
     void supprimer(int id);
     Employee findById(int EmployeeId);
}
