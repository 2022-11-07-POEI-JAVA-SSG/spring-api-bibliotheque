package com.example.bibliotheque.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LivreRepository extends JpaRepository<Livre,Integer> {

    // Solution 1
    List<Livre> findAllByTitreContainingIgnoreCaseOrResumeContainingIgnoreCase(String title, String resume);

    // Solution 2
    //iLIKE : psql specific !!!
    @Query(value="SELECT livre FROM Livre livre WHERE livre.titre iLIKE %:keyword% OR livre.resume iLIKE %:keyword%")
    List<Livre> searchLivres(String keyword);

    // Solution 3 : WHERE UPPER(livre.titre) LIKE UPPER(%:keyword%)
    // https://stackoverflow.com/questions/16082575/sql-ignore-case-while-searching-for-a-string
}