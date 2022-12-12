package com.example.yogaclass.repository;

import com.example.yogaclass.models.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.In;

public interface ClassesRepository extends JpaRepository<Classes, Long> {

}
