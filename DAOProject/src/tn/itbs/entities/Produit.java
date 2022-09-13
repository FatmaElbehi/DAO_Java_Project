package tn.itbs.entities;

import java.io.Serializable;

//bean (ou entité) produit
public class Produit implements Serializable {
	private int id;
	private String nom;
	private int qte;
	public Produit(int id, String nom, int qte) {
		this.id = id;
		this.nom = nom;
		this.qte = qte;
	}
	public Produit() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	
	
	
}
