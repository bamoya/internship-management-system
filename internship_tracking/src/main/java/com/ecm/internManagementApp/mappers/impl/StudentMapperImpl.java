package com.ecm.internManagementApp.mappers.impl;

import com.ecm.internManagementApp.model.dto.StudentDto;
import com.ecm.internManagementApp.mappers.Mapper;
import com.ecm.internManagementApp.model.entities.Student;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

@Component
public class StudentMapperImpl implements Mapper<Student, StudentDto> {


    private ModelMapper modelMapper;

    public StudentMapperImpl(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
        this.modelMapper.getConfiguration()
                .setSkipNullEnabled(true) // Ignore null values in the DTO
                .setMatchingStrategy(MatchingStrategies.STRICT); // Match field names exactly
    }
    @Override
    public StudentDto mapToDto(Student student){
        return modelMapper.map(student, StudentDto.class );
    }

    @Override
    public Student mapFromDto(StudentDto studentDto){
        return modelMapper.map(studentDto, Student.class);
    }

//    public void updateStudentFromDto(StudentDto dto, @MappingTarget Student student) {
//        modelMapper.map(dto, student);
//    }
}
