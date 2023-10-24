package com.sidib.demo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.sidib.demo.entities.Produit;

@SpringBootApplication
//interface commandLinneRunner nous permet de retourner ID 
public class ProduitsApplication implements CommandLineRunner{
	//injection de dependance 
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	//methode principale de l'appli : point d'entrer de l'app
	public static void main(String[] args) {
		SpringApplication.run(ProduitsApplication.class, args);
	}
	//methode pour retourner les ID apres une requete API REST
	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Produit.class);
	}
	@Bean
	public ModelMapper modelMapper()
	{
	return new ModelMapper();
	}
}
