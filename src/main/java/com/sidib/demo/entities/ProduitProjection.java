package com.sidib.demo.entities;

import org.springframework.data.rest.core.config.Projection;// resteindre le resultat retourner à certains un nbre attribut apres une requête

@Projection(name="nomProd", types= {Produit.class}) //retourne only nom du produit apres une requete 
public interface ProduitProjection {
	public String getNomProduit();
}
