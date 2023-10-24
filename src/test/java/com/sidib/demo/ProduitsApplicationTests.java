package com.sidib.demo;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sidib.demo.entities.Categorie;
import com.sidib.demo.entities.Produit;
import com.sidib.demo.repos.ProduitRepository;

@SpringBootTest
class ProduitsApplicationTests {
	@Autowired
private ProduitRepository produitReepository;
	//Creat 
	@Test
	public void testCreatProduit() {
		Produit prod= new Produit("PC ASSUS",800.50,new Date());
		produitReepository.save(prod);
		
	}
	//Delete
	@Test
	public void testDeleteProduit() {
		produitReepository.deleteById(3L);
	}
	//Read
	@Test
	public void testFindProduit() {
		Produit	p = produitReepository.findById(1L).get();
		System.out.println(p);
	}
	//Update
	@Test
	public void testUpdateProduit(){
		Produit p= produitReepository.findById(1L).get();
		//p.setPrixProduit(500.00);
		p.setNomProduit("Samsung S10");
		produitReepository.save(p);
		System.out.println(p);
	}
	//Recuperer tout
	@Test
	public void testListerTousProduit(){
		List<Produit> prods= produitReepository.findAll();
		for (Produit p : prods) {
			System.out.println(p);
		}
	}
	//Recuperer un produit par nom
	@Test
	public void testfindByNomProduit(){
	List<Produit> prods = produitReepository.findByNomProduit("IPHONE 14");
		for(Produit p : prods) {
		System.out.println(p);
		}
	}
	//Récuperer les produits contenant ce nom
	@Test
	public void testfindByNomProduitContains() 
	{
		List<Produit> prods = produitReepository.findByNomProduitContains("N");
		for(Produit p : prods)
		{
			System.out.println(p);
		}		
	}
	//Récuperer nom et prix avec JPAQL
	@Test
	public void testfindByNomPrix() 
	{
	List<Produit> prods = produitReepository.findByNomPrix("PC ASSUS", 500.5);
		for (Produit p : prods) 
		{
			System.out.println(p);
		}
		
	}
	//Récuperer les produit de meme  categorie avec JPAQL
	@Test
	public void testfindbyCategorie()
	{
		Categorie cat = new Categorie();
		cat.setIdCat(1L);
		List<Produit> prods = produitReepository.findByCategorie(cat);
		for (Produit p :  prods)
		{ 
			System.out.println(p);
		}
	}
	//Récuperer un produit en fonction de idCat 
	@Test
	 public void findByCategorieIdCat()
	{
		List<Produit> prods = produitReepository.findByCategorieIdCat(1L);
			for ( Produit p : prods )
			{ 
				System.out.println(p);		
			}
	}
	//Trier produit par nom ordre croissant 
	@Test
	public void testfindByOrderByNomProduitAsc() 
	{
		List<Produit> prods = produitReepository.findByOrderByNomProduitAsc();
		for ( Produit p : prods)
		{
			System.out.println(p);
		}
	}
	//Trier produit par ordre nom asc et prix dsc
	@Test
	public void testTrierProduitsNomsPrix()
	{
		List<Produit> prods = produitReepository.trierProduitsNomsPrix();
		for (Produit p : prods)
		{
			System.out.println(p);
		}
		
	}
}
