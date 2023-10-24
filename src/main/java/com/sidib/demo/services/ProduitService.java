package com.sidib.demo.services;

import java.util.List;

import com.sidib.demo.dto.ProduitDto;
import com.sidib.demo.entities.Categorie;
import com.sidib.demo.entities.Produit;

public interface ProduitService {
	
 //Declarations des methodes CRUD
	/*
	//Methode creat produit
	Produit saveProduit(Produit p);
	//Methode Update produit
	Produit updateProduit(Produit p);
	//All
	List<Produit> getAllProduit();
	*/
//Conversion en DTO	
	//Methode creat produit
		ProduitDto saveProduit(ProduitDto p);
	//Methode Update produit
		ProduitDto updateProduit(ProduitDto p);
	//getAll
		List<ProduitDto> getAllProduit();
	
		
	//Methode Delete produit
	void deleteProduit(Produit p);
	//By id
	void deleteProduitbyId(Long id);
	//Methode récuperer produit
	//by id
	Produit getProduit(Long id);
	
	
// Declaration des methodes supl que j'ai ajoutées	
	//récuperer un produit par son nom
	List<Produit> findByNomProduit(String nom);
	//recuperer les produits contenant une chaine de charactere
	List<Produit> findByNomProduitContains(String nom);
	//Récuperer nom et prix d'un produit
	List<Produit> findByNomPrix(String nom, Double prix);
	//Recuperer les produits de mmeme categorie JPQL
	List<Produit> findByCategorie(Categorie categorie);
	//Récuperer les produit par Id de leur categorie
	List<Produit> findByCategorieIdCat(Long id);
	//Trier Produit par ordre de nom
	List<Produit> findByOrderByNomProduitAsc();
	//Trier Produit par nom et prix
	List<Produit> trierProduitsNomsPrix();
	
//methode pour convertir les entités prod en DTO prod
	ProduitDto convertEntityToDto(Produit p);
//methode pour convertir les DTO en entity
	Produit convertDtoToEntity(ProduitDto produitDto);
}
