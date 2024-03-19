package com.ecm.internManagementApp.service;

import com.ecm.internManagementApp.exception.TeacherNotFoundException;
import com.ecm.internManagementApp.model.entities.Teacher;
import com.ecm.internManagementApp.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public boolean isExists(Long id){
        return teacherRepository.existsById(id);
    }

    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(Long id){
        return teacherRepository.findById(id)
                .orElseThrow(()-> new TeacherNotFoundException("teacher by id "+id+" wasn't found."));
    }

    public Teacher saveTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    public List<Teacher> saveListOfTeachers(List<Teacher> teachers){
        return teacherRepository.saveAll(teachers);
    }

    public Teacher updateTeacher(Long id, Teacher teacher){
        if (teacherRepository.existsById(id)){
            teacher.setId(id);
            return teacherRepository.save(teacher);
        }
        throw new TeacherNotFoundException("teacher with id "+id+" not found");
    }

    public void deleteTeacher(Long id){
        teacherRepository.deleteById(id);
    }

//    public Teacher patchTeacher(Long id, Map<String, Object> updates) {
//    }
}
