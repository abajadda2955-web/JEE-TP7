package com.example.studentmanagement.repository;



import java.util.Collection;

import com.example.studentmanagement.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.studentmanagement.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {


    // Recherche d'un étudiant par son id
    Student findById(int id);

    // Requête personnalisée pour calculer le nombre des étudiants par année de naissance
    @Query("SELECT YEAR(s.dateNaissance), COUNT(s) FROM Student s GROUP BY YEAR(s.dateNaissance)")
    Collection<Object[]> findNbrStudentByYear();
}