package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Matiere;
@Repository
public interface matiereRepo extends JpaRepository<Matiere, Long> {

}
