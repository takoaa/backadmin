package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Matiere {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String nom;
	    private Long epaisseur ;
		public Matiere() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Matiere(Long id, String nom, Long epaisseur) {
			super();
			this.id = id;
			this.nom = nom;
			this.epaisseur = epaisseur;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public Long getEpaisseur() {
			return epaisseur;
		}
		public void setEpaisseur(Long epaisseur) {
			this.epaisseur = epaisseur;
		}
	
}
