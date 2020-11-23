package com.Sandar.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Sandar.demo.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
