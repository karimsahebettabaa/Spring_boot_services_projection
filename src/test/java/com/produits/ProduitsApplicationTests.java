package com.produits;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.produits.entities.Categorie;
import com.produits.entities.Produit;
import com.produits.repos.ProduitRepository;

@SpringBootTest
class ProduitsApplicationTests {

	@Autowired
	private ProduitRepository produitRepository;
	
	@Test
	public void testCreateProduit() {
		Produit prod = new Produit("Pc dell", 2200.500, new Date());
		
		produitRepository.save(prod);
	}
	
	@Test
	public void testFindProduit() {
		Produit p = produitRepository.findById(2L).get();
		System.out.println(p);
	}
	
	@Test
	public void testUpdateProduit() {
		Produit p = produitRepository.findById(2L).get();
		p.setPrixProduit(2000.0);
		produitRepository.save(p);
		System.out.println(p);
	}
	
	@Test
	public void testDeleteProduit() {
		produitRepository.deleteById(2L);
		
	}
	
	@Test
	public void testFindAllProduits() {
		List<Produit> prods = produitRepository.findAll();
		
		for (Produit p:prods)
			System.out.println(p);
		
	}
	
	@Test
	public void testFindProduitByNom() {
		List<Produit> prods = produitRepository.findByNomProduit("Pc dell");
		
		for (Produit p:prods)
			System.out.println(p);
	}
	
	@Test
	public void testFindProduitByNomContains() {
		List<Produit> prods = produitRepository.findByNomProduitContains("P");
		
		for (Produit p:prods)
			System.out.println(p);
	}
	
	@Test
	public void testFindByNomPrix() {
		List<Produit> prods = produitRepository.findByNomPrix("Pc dell", 1000.0);
		
		for (Produit p:prods)
			System.out.println(p);
	}
	
	@Test
	public void testFindCategorie() {
		Categorie cat = new Categorie();
		cat.setIdCat(1L);
		
		List<Produit> prods = produitRepository.findByCategorie(cat);
		
		for (Produit p:prods)
			System.out.println(p);
	}
	
	@Test
	public void testFindByCategorieIdCat() {
		List<Produit> prods = produitRepository.findByCategorieIdCat(2L);
		
		for (Produit p:prods)
			System.out.println(p);
	}
	
	@Test
	public void testFindByOrderByNomProduit() {
		List<Produit> prods = produitRepository.findByOrderByNomProduitAsc();
		
		for (Produit p:prods)
			System.out.println(p);
	}
	
	
	@Test
	public void testTrierProduitsNomsPrix() {
		List<Produit> prods = produitRepository.trierProduitsNomsPrix();
		
		for (Produit p:prods)
			System.out.println(p);
	}
	

}
