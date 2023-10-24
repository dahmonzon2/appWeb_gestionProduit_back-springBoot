package com.sidib.demo.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sidib.demo.dto.ProduitDto;
import com.sidib.demo.entities.Produit;
import com.sidib.demo.services.ProduitService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProduitRESTController {
    //injection de dependance
	@Autowired
	ProduitService produitService;
	//web service qui retourne tous les produits
	@RequestMapping(method = RequestMethod.GET)
	List<ProduitDto> getAllProduit()
	{
		return produitService.getAllProduit();
	}
	//web service qui retourne un produit
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Produit getProduitById(@PathVariable("id") Long id)
	{
		return produitService.getProduit(id);
	}
	//web service pour creer un produit
	@RequestMapping(method = RequestMethod.POST)
	public ProduitDto createProduit(@RequestBody ProduitDto produitDto)
	{
		return produitService.saveProduit(produitDto);
	}
	//web service qui modifie un produit dans la BDD
	@RequestMapping(method = RequestMethod.PUT)
	public ProduitDto updateProduit(@RequestBody ProduitDto produitDto)
	{
		return produitService.updateProduit(produitDto);
	}
	//web service qui supprime un produit dans la BDD
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void  deleteProduit(@PathVariable Long id)
	{
		produitService.deleteProduitbyId(id);
	}
	//web service qui retourne les produits de meme categorie by idCat 
	@RequestMapping(value = "/prodscat/{idCat}", method = RequestMethod.GET)
	public List<Produit> getProduitByIdCat(@PathVariable Long idCat)
	{
		return produitService.findByCategorieIdCat(idCat);
	}
}
