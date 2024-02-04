package com.vikram.singh.springbootjpa.services.impl;

import com.vikram.singh.springbootjpa.converter.Converter;
import com.vikram.singh.springbootjpa.dto.StudentDto;
import com.vikram.singh.springbootjpa.repositories.StudentRepository;
import com.vikram.singh.springbootjpa.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public StudentDto getStudentById(int id) {
        var studentEntity = this.studentRepository.getById(id);
        return Converter.toStudentDto(studentEntity);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        var studentEntityList = this.studentRepository.findAll();
        return Converter.toStudentDtoList(studentEntityList);
    }

    @Override
    public void updateStudent(int id, StudentDto studentDto) {
        var studentEntity = Converter.toStudentUpdateEntity(id, studentDto);
        this.studentRepository.save(studentEntity);
    }

    @Override
    public void addStudent(StudentDto studentDto) {
        var studentEntity = Converter.toStudentEntity(studentDto);
        this.studentRepository.save(studentEntity);
    }

    @Override
    public void deleteStudent(int id) {
        this.studentRepository.deleteById(id);
    }
}
