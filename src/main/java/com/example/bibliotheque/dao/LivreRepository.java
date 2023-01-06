package com.example.bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivreRepository extends JpaRepository<Livre,Integer> {

    public List<Livre> findAllByTitreContainingIgnoreCaseOrResumeContainingIgnoreCase(String title, String resume);
}