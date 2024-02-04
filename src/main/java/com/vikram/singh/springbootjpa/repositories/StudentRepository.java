package com.vikram.singh.springbootjpa.repositories;

import com.vikram.singh.springbootjpa.datamodel.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

    StudentEntity getById(int id);

}
