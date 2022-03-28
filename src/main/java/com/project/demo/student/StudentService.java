package com.project.demo.student;

import java.util.List;
<<<<<<< HEAD
import java.util.Optional;
import java.util.UUID;
=======
>>>>>>> 11ea5b37f781ea12f2d3dac72fbe9a888d40513f

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
@Service
public class StudentService {

=======
// This class is manly for bussiness logic
@Service
public class StudentService {
    
    // Dependency injection
>>>>>>> 11ea5b37f781ea12f2d3dac72fbe9a888d40513f
    private final StudentDataAcessService studentDataAcessService;

    @Autowired
    public StudentService(StudentDataAcessService studentDataAcessService){
        this.studentDataAcessService = studentDataAcessService;
    }

    public List<Student> getAllStudents() {
<<<<<<< HEAD
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
=======
        return studentDataAcessService.selectAllStudent();
>>>>>>> 11ea5b37f781ea12f2d3dac72fbe9a888d40513f
    }
}
