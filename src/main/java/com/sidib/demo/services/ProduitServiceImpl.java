package com.sidib.demo.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sidib.demo.dto.ProduitDto;
import com.sidib.demo.entities.Categorie;
import com.sidib.demo.entities.Produit;
import com.sidib.demo.repos.ProduitRepository;
@Service
//Implementation de l'interface ProduitService
public class ProduitServiceImpl implements ProduitService{
//injection de dependance
	@Autowired
	ModelMapper	modelMapper;
//Définition des méthodes déclarer dans l'interface ProduitService
	//Injection de dependance
	@Autowired  
	ProduitRepository produitRepository;
	
	/*
	//Creat
	@Override
	public Produit saveProduit(Produit p) {
		return produitRepository.save(p);
	}
	//Update
	@Override
	public Produit updateProduit(Produit p) {
		return produitRepository.save(p);
	}
	//Read All = récuperer tout 
	@Override
	public List<Produit> getAllProduit() {
		return produitRepository.findAll();
	}
	
	*/
//convert enttity to DTO
		//Creat
		@Override
		public ProduitDto saveProduit(ProduitDto p) {
			return convertEntityToDto(produitRepository.save(convertDtoToEntity(p)));
		}
		//Update
		@Override
		public ProduitDto updateProduit(ProduitDto p) {
			return  convertEntityToDto(produitRepository.save(convertDtoToEntity(p)));
		}
		//Read All = récuperer tout 
		@Override
		public List<ProduitDto> getAllProduit() {
		//premiere methode 
			/*List<Produit> prods	= produitRepository.findAll();
			List<ProduitDto> listprodDto = new ArrayList<ProduitDto>(prods.size());
				for	(Produit p : prods)
				{
					listprodDto.add(convertEntityToDto(p));
				}
					return listprodDto;
				}*/
		// Deuxieme methode: Java functional programming 
		
			return produitRepository.findAll().stream() 
					.map(this::convertEntityToDto)
					.collect(Collectors.toList());
		}
	
	//Delete
	@Override
	public void deleteProduit(Produit p) {
		produitRepository.delete(p);
	}
	//Delete
	@Override
	public void deleteProduitbyId(Long id) {
		produitRepository.deleteById(id);
	}
	//Read = Récuperer
	@Override
	public Produit getProduit(Long id) {
		return produitRepository.findById(id).get();
	}
	
	
	
	@Override
	public List<Produit> findByNomProduit(String nom) {
		return produitRepository.findByNomProduit(nom);
	}
	@Override
	public List<Produit> findByNomProduitContains(String nom) {
		return produitRepository.findByNomProduitContains(nom);
	}
	@Override
	public List<Produit> findByNomPrix(String nom, Double prix) {
		return produitRepository.findByNomPrix(nom, prix);
	}
	@Override
	public List<Produit> findByCategorie(Categorie categorie) {
		return produitRepository.findByCategorie(categorie);
	}
	@Override
	public List<Produit> findByCategorieIdCat(Long id) {
		return produitRepository.findByCategorieIdCat(id);
	}
	@Override
	public List<Produit> findByOrderByNomProduitAsc() {
		return produitRepository.findByOrderByNomProduitAsc();
	}
	@Override
	public List<Produit> trierProduitsNomsPrix() {
		return produitRepository.trierProduitsNomsPrix();
	}
//implementation de la methode convertEntityTODto
	
	//premiere maniere 
	/*@Override
	public ProduitDto convertEntityToDto(Produit p)
	{
		ProduitDto produitDto = new ProduitDto();
		produitDto.setIdProduit(p.getIdProduit());
		produitDto.setNomProduit(p.getNomProduit());
		produitDto.setPrixProduit(p.getPrixProduit());
		produitDto.setDateCreation(p.getDateCreation());
		produitDto.setCategorie(p.getCategorie());
		return produitDto;
	}
	*/
	//Deuxieme maniere 
	/*@Override
	public ProduitDto convertEntityToDto(Produit p)
	{
		return 	ProduitDto.builder()
				.idProduit(p.getIdProduit())
				.nomProduit(p.getNomProduit())
				.prixProduit(p.getPrixProduit())
				.dateCreation(p.getDateCreation())
				.nomCat(p.getCategorie().getNomCat())
				.categorie(p.getCategorie())
				.build();			
	}
	*/
	//troisieme maniere: Methode avec ModelMapper biblioJava
	@Override
	public ProduitDto convertEntityToDto(Produit p) //p:produit
	{
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);// correspondance des attributs moins precis : pour obtenir la valeur nomCat
		ProduitDto	produitDto = modelMapper.map(p, ProduitDto.class);
		return	produitDto;
	}
//Implementation de la methode convertDtoToEntity
	/*
	 @Override
	 
	public Produit convertDtoToEntity(ProduitDto produitDto)
	{
		Produit produit = new Produit();
		produit.setIdProduit(produitDto.getIdProduit());
		produit.setNomProduit(produitDto.getNomProduit());
		produit.setPrixProduit(produitDto.getPrixProduit());
		produit.setDateCreation(produitDto.getDateCreation());
		produit.setCategorie(produitDto.getCategorie());
		return produit;
		
	}
	*/
	@Override
	public Produit convertDtoToEntity(ProduitDto produitDto)
	{
		Produit produit = new Produit();
		produit = modelMapper.map(produitDto, Produit.class);
		return produit;
	}
	
}
