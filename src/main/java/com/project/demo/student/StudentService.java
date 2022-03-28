package com.project.demo.student;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    void addNewStudent(Student student) {
        addNewStudent(null, student);
    }


    List<Student> addNewStudent(UUID studentId, Student student) {
        UUID newStudentId = Optional.ofNullable(studentId)
                .orElse(UUID.randomUUID());
        // TODO: Verify that emails is not taken
        studentDataAcessService.insertStudent(newStudentId, student);
        return studentDataAcessService.selectAllStudent();
    }
}
