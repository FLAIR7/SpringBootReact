package com.project.demo.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import com.project.demo.exception.ApiRequestException;
import com.project.demo.model.Student;
import com.project.demo.model.StudentCourse;
import com.project.demo.services.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/students")
public class StudentController {
    
    // Dependency Injection
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(path = "{studentId}/courses")
    public List<StudentCourse> getAllCoursesForStudent(@PathVariable("studentId") UUID studentId) {
        return studentService.getAllCoursesForStudent(studentId);
    }

    @PostMapping
    public void addNewStudent(@RequestBody @Valid Student student) {
        studentService.addNewStudent(student);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") UUID studentId,
                              @RequestBody Student student) {
        studentService.updateStudent(studentId, student);
    }

    @DeleteMapping("{studentId}")
    public void deleteStudent(@PathVariable("studentId") UUID studentId) {
        studentService.deleteStudent(studentId);
    }

}
