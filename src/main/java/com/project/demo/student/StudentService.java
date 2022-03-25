package com.project.demo.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// This class is manly for bussiness logic
@Service
public class StudentService {
    
    // Dependency injection
    private final StudentDataAcessService studentDataAcessService;

    @Autowired
    public StudentService(StudentDataAcessService studentDataAcessService){
        this.studentDataAcessService = studentDataAcessService;
    }

    public List<Student> getAllStudents() {
        return studentDataAcessService.selectAllStudent();
    }
}
