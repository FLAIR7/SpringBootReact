package com.project.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;

import com.project.demo.EmailValidator;
import com.project.demo.exception.ApiRequestException;
import com.project.demo.model.Student;
import com.project.demo.student.StudentDataAcessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// This class is manly for bussiness logic
@Service
public class StudentService {
    
    // Dependency injection
    private final StudentDataAcessService studentDataAcessService;
    private final EmailValidator emailValidator;


    @Autowired
    public StudentService(StudentDataAcessService studentDataAcessService, EmailValidator emailValidator){
        this.studentDataAcessService = studentDataAcessService;
        this.emailValidator = emailValidator;
    }

    public List<Student> getAllStudents() {
        return studentDataAcessService.selectAllStudent();
    }

    public void addNewStudent(Student student) {
        addNewStudent(null, student);
    }

    void addNewStudent(UUID studentId, Student student) {
        UUID newStudentId = Optional.ofNullable(studentId)
                .orElse(UUID.randomUUID());
        // TODO: Verify that emails is not taken
        if(!emailValidator.test(student.getEmail())) {
            throw new ApiRequestException(student.getEmail() + " is not valid");
        }

        if(studentDataAcessService.isEmailTaken(student.getEmail())) {
            throw new ApiRequestException(student.getEmail() + " is taken");
        }

        
        studentDataAcessService.insertStudent(newStudentId, student);
    }
}
