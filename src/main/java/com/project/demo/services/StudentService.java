package com.project.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;

import com.project.demo.EmailValidator;
import com.project.demo.exception.ApiRequestException;
import com.project.demo.model.Student;
import com.project.demo.model.StudentCourse;
import com.project.demo.student.StudentDataAcessService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

    public List<StudentCourse> getAllCoursesForStudent(UUID studentId) {
        return studentDataAcessService.selectAllStudentCourses(studentId);
    }

    public void updateStudent(UUID studentId, Student student) {
        Optional.ofNullable(student.getEmail())
                .ifPresent(email -> {
                    boolean emailtaken = studentDataAcessService.selectExistsEmail(studentId, email);
                    if(!emailtaken) {
                        studentDataAcessService.updateEmail(studentId, email);
                    } else {
                        throw new IllegalStateException("Email " + student.getEmail() + " is already in use");
                    }
                });
        Optional.ofNullable(student.getFirstName())
                .filter(firstName -> !StringUtils.isEmpty(firstName))
                .map(StringUtils::capitalize)
                .ifPresent(firstName -> studentDataAcessService.updateFirstName(studentId, firstName));

        Optional.ofNullable(student.getLastName())
                .filter(lastName -> !StringUtils.isEmpty(lastName))
                .map(StringUtils::capitalize)
                .ifPresent(lastName -> studentDataAcessService.updateLastName(studentId, lastName));
    }

    public void deleteStudent(UUID studentId){
        studentDataAcessService.deleteStudentById(studentId);
    }
}
