package com.sidib.demo.dto;

import java.util.Date;

import com.sidib.demo.entities.Categorie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // facilite la creation des objets type design pattern dto
public class ProduitDto {
	
	private Long idProduit;
	private String nomProduit;
	private Double prixProduit;
	private Date dateCreation;
	private Categorie categorie;
	private String nomCat;
}
