package com.example.demo.entities;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;




@Entity  //pour que la classe Livre soit considéré comme une table dans la base de donnée
@Table(name = "Livres")
public class Livres {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) // permet de générer de manière automatique par springboot les id
	@Column(name = "id_livre")
    private int id;
	
	@NotNull
	@Column(name = "titre")
	private String titre;
	
	@NotNull
	@Column(name = "editeur")
	private String editeur;
	
	@NotNull
	@Column(name = "auteur")
	private String auteur;
	
	@Column(name = "categorie")
	private String categorie;
	
	@NotNull
	@Column(name = "qte_stock")
	private int qte_stock;
	






	public Livres() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	

	public Livres(int id, String titre, String editeur, String auteur, String categorie, int qte_stock) {
		super();
		this.id = id;
		this.titre = titre;
		this.editeur = editeur;
		this.auteur = auteur;
		this.categorie = categorie;
		this.qte_stock = qte_stock;
	}


	


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public String getEditeur() {
		return editeur;
	}


	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}


	public String getAuteur() {
		return auteur;
	}


	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}


	public String getCategorie() {
		return categorie;
	}


	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}


	public int getQte_stock() {
		return qte_stock;
	}


	public void setQte_stock(int qte_stock) {
		this.qte_stock = qte_stock;
	}





	@Override
	public String toString() {
		return "Livres [id=" + id + ", titre=" + titre + ", editeur=" + editeur + ", auteur=" + auteur + ", categorie="
				+ categorie + ", qte_stock=" + qte_stock + "]";
	}


	


	
}
