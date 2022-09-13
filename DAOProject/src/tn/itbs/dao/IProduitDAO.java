package tn.itbs.dao;

import java.util.List;

import tn.itbs.entities.Produit;
//méthodes CRUD
public interface IProduitDAO {
	// ajouter,  chercherTout et chercher par id
	
	void save(Produit d);
	List<Produit> findAll();
	Produit findById(int id);
	 
}
