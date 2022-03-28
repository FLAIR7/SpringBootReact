package com.project.demo.student;

import java.util.List;
import java.util.UUID;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDataAcessService {
    
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentDataAcessService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    List<Student> selectAllStudents() {
        String sql = "" +
                "SELECT " +
                " student_id, " + 
                " first_name, " + 
=======
// import org.flywaydb.core.internal.jdbc.JdbcTemplate;
// import org.flywaydb.core.internal.jdbc.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@Repository
public class StudentDataAcessService {

    // Dependency injection
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentDataAcessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    List<Student> selectAllStudent(){
        String sql = "" + 
                "SELECT " + 
                " student_id, " +
                " first_name, " +
>>>>>>> 11ea5b37f781ea12f2d3dac72fbe9a888d40513f
                " last_name, " + 
                " email, " + 
                " gender " + 
                "FROM student";
<<<<<<< HEAD
        return jdbcTemplate.query(sql, mapStudentFromDb());
    }

    int insertStudent(UUID studentId, Student student) {
        String sql = "" +
                "INSERT INTO student(" +
                " student_id," +
                " first_name," +
                " last_name," +
                " email," +
                " gender) " +
                "VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(
            sql,
            studentId,
            student.getFirstName(),
            student.getLastName(),
            student.getEmail(),
            student.getGender().name().toUpperCase()
        );
    }

    private RowMapper<Student> mapStudentFromDb() {
=======
        return jdbcTemplate.query(sql, mapStudentFromDb());    
     }

     @Bean
     private RowMapper<Student> mapStudentFromDb() {
>>>>>>> 11ea5b37f781ea12f2d3dac72fbe9a888d40513f
        return (resultSet, i) -> {
            String studentIdStr = resultSet.getString("student_id");
            UUID studentId = UUID.fromString(studentIdStr);

            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String email = resultSet.getString("email");
            String genderStr = resultSet.getString("gender").toUpperCase();
            Student.Gender gender = Student.Gender.valueOf(genderStr);
<<<<<<< HEAD
=======

>>>>>>> 11ea5b37f781ea12f2d3dac72fbe9a888d40513f
            return new Student(
                studentId, 
                firstName, 
                lastName, 
                email, 
                gender
            );
        };
<<<<<<< HEAD
    }
    
}
=======
     }
    
}

// return List.of(
//             new Student(UUID.randomUUID(), "João", "Sousa", "joaosousa@gmail.com", Student.Gender.MALE),
//             new Student(UUID.randomUUID(), "Daniela", "Leão", "danielaleao@hotmail.com", Student.Gender.FEMALE)
//         );
>>>>>>> 11ea5b37f781ea12f2d3dac72fbe9a888d40513f
