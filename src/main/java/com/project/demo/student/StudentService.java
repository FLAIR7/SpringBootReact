package com.project.demo.student;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentDataAcessService studentDataAcessService;

    @Autowired
    public StudentService(StudentDataAcessService studentDataAcessService){
        this.studentDataAcessService = studentDataAcessService;
    }

    public List<Student> getAllStudents() {
        return studentDataAcessService.selectAllStudents();
    }

    void addNewStudent(Student student) {
        addNewStudent(null, student);
    }


    void addNewStudent(UUID studentId, Student student) {
        UUID newStudentId = Optional.ofNullable(studentId)
                .orElse(UUID.randomUUID());
        // TODO: Verify that emails is not taken
        studentDataAcessService.insertStudent(newStudentId, student);
    }
}
