package com.vikram.singh.springbootjpa.services;

import com.vikram.singh.springbootjpa.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto getStudentById(int id);

    List<StudentDto> getAllStudents();

    void updateStudent(int id, StudentDto studentDto);

    void addStudent(StudentDto studentDto);

    void deleteStudent(int id);
}
