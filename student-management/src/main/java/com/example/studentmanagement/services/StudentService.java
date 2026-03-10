package com.example.studentmanagement.services;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.repository.StudentRepository;
import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
//save

    public Student save(Student student) {
        return studentRepository.save(student);
    }
//delete
    public boolean delete(int id) {
        Optional<Student> studentOptional = Optional.ofNullable(studentRepository.findById(id));
        if (studentOptional.isPresent()) {
            studentRepository.delete(studentOptional.get());
            return true;
        } else {
            return false;
        }
    }
//trouver tous les etudiants
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
//calculer le bn des etudiants
    public long countStudents() {
        return studentRepository.count();
    }
// calculer le nb des etudiant par annee de naissance
    public Collection<?> findNbrStudentByYear() {
        return studentRepository.findNbrStudentByYear();
    }
}
