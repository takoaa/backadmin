package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.example.demo.model.Matiere;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.persistence.EntityNotFoundException;

import com.example.demo.Repository.matiereRepo; // Ensure correct package name


import java.util.List;


@RestController
@RequestMapping("/api/matiere") 
@CrossOrigin(origins = "http://localhost:4200")
public class matiereController {

    @Autowired
    private matiereRepo matiereRepo; // Inject the repository

    @PostMapping
    public Matiere createMatiere(@RequestBody Matiere matiere) {
        return matiereRepo.save(matiere);
    }

    @GetMapping
    public List<Matiere> getAllMatiere() {
        return matiereRepo.findAll();
    }

    @GetMapping("/{id}")
    public Matiere getMatiereById(@PathVariable Long id) {
        return matiereRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id " + id));
    }

    @PutMapping("/{id}")
    public Matiere updateMatiere(@PathVariable Long id, @RequestBody Matiere matiereDetails) {
        System.out.println("Updating Matiere with id: " + id);
        System.out.println("Received details: " + matiereDetails.toString());  // This assumes you have a proper toString() method in your Matiere class

        // Fetch the existing Matiere from the database
        Matiere matiere = matiereRepo.findById(id).orElseThrow(() -> 
            new EntityNotFoundException("Matiere not found with id " + id));

        // Set the new values from the request body
        matiere.setNom(matiereDetails.getNom());
        matiere.setEpaisseur(matiereDetails.getEpaisseur());

        // Save the updated Matiere back to the database
        return matiereRepo.save(matiere);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMatiere(@PathVariable Long id) {
        Matiere matiere = matiereRepo.findById(id).orElseThrow(() -> 
            new EntityNotFoundException("Matiere not found with id " + id));

        matiereRepo.delete(matiere);
        return ResponseEntity.ok().build();
    }
}