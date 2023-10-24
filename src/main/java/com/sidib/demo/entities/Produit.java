package com.sidib.demo.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
//Entity c'est pour persister la classe Produit dans ma BDD
@Entity 
public class Produit {
	@Id // cle primaire
	@GeneratedValue(strategy = GenerationType.IDENTITY)// auto-incrementation de ID
	private Long idProduit;
	private String nomProduit;
	private Double prixProduit;
	private Date dateCreation;
//Relation entre les deux entités 
	@ManyToOne
	private Categorie categorie;
	
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
public Produit(String nomProduit, Double prixProduit, Date dateCreation) {
	super();
	this.nomProduit = nomProduit;
	this.prixProduit = prixProduit;
	this.dateCreation = dateCreation;
}
public Long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	public Double getPrixProduit() {
		return prixProduit;
	}
	public void setPrixProduit(Double prixProduit) {
		this.prixProduit = prixProduit;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", nomProduit=" + nomProduit + ", prixProduit=" + prixProduit
				+ ", dateCreation=" + dateCreation + "]";
	}
	
	public Categorie getCategorie() {
		return categorie;
	}
	
	
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
}
