package com.sidib.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.sidib.demo.entities.Categorie;
import com.sidib.demo.entities.Produit;
@RepositoryRestResource(path = "rest")//genere automatique les web services CRUD et autres
public interface ProduitRepository extends JpaRepository<Produit, Long> {
	//recuperer les  produits par nom
	List<Produit> findByNomProduit(String nom);
	//recuperer les produits contenant une chaine de charactere
	List<Produit> findByNomProduitContains(String nom);
	//Requête @Query pour récuperer le nom et prix d'un produit dans l'entité produit
	@Query("select p from Produit p where p.nomProduit like %?1 and p.prixProduit > ?2")
	List<Produit> findByNomPrix(String nom, Double prix);
	//@Query("select p from Produit p where p.nomProduit like %:nom and p.prixProduit	> :prix")
	//List<Produit> findByNomPrix(@Param("nom") String nom, @Param("prix") Double prix);
	//Recuperer les produits de mmeme categorie JPQL
	@Query("select p from Produit p where p.categorie =?1 ")
	List<Produit> findByCategorie(Categorie categorie);
	//Récuperer un produit par Id de leur categorie
	List<Produit> findByCategorieIdCat(Long id);
	//Trier Produit par ordre de nom
	List<Produit> findByOrderByNomProduitAsc();
	//Trier Produit par nom et prix
	@Query("select p from Produit p order by p.nomProduit ASC, p.prixProduit DESC")
	List<Produit> trierProduitsNomsPrix();
}
