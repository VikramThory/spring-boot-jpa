package com.vikram.singh.springbootjpa.converter;

import com.vikram.singh.springbootjpa.datamodel.StudentEntity;
import com.vikram.singh.springbootjpa.dto.StudentDto;

import java.util.List;

public class Converter {

    public static StudentDto toStudentDto(StudentEntity studentEntity) {
        return new StudentDto(studentEntity.getName(), studentEntity.getStandard(), studentEntity.getSection());
    }

    public static StudentEntity toStudentEntity(StudentDto studentDto) {
        var studentEntity = new StudentEntity();
        studentEntity.setName(studentDto.name());
        studentEntity.setStandard(studentDto.standard());
        studentEntity.setSection(studentDto.section());
        return studentEntity;
    }

    public static StudentEntity toStudentUpdateEntity(int id, StudentDto studentDto) {
        var studentEntity = new StudentEntity();
        studentEntity.setId(id);
        studentEntity.setName(studentDto.name());
        studentEntity.setStandard(studentDto.standard());
        studentEntity.setSection(studentDto.section());
        return studentEntity;
    }

    public static List<StudentDto> toStudentDtoList(List<StudentEntity> studentEntityList) {
        return studentEntityList
                .stream()
                .map(Converter::toStudentDto)
                .toList();
    }

}
