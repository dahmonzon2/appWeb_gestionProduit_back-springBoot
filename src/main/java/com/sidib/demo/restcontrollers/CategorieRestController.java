package com.sidib.demo.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sidib.demo.entities.Categorie;
import com.sidib.demo.repos.CategorieRepository;

@RestController
@RequestMapping("/api/cat")
@CrossOrigin("*")
public class CategorieRestController 
{
	@Autowired
	CategorieRepository categorieRepository;
	
	//API REST qui retourne tous les categories
	@RequestMapping(method = RequestMethod.GET)
	public List<Categorie> getAllCategorie()
		{
			return categorieRepository.findAll();
		}
	//API REST qui retourne un categorie en fonction de ID
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Categorie getCategorieById(@PathVariable("id") Long id)
		{
			return categorieRepository.findById(id).get();
		}
}
