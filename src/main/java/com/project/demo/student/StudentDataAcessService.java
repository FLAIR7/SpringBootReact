package com.project.demo.student;

import java.util.List;
import java.util.UUID;

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
                " last_name, " + 
                " email, " + 
                " gender " + 
                "FROM student";
        return jdbcTemplate.query(sql, mapStudentFromDb());    
     }

     @Bean
     private RowMapper<Student> mapStudentFromDb() {
        return (resultSet, i) -> {
            String studentIdStr = resultSet.getString("student_id");
            UUID studentId = UUID.fromString(studentIdStr);

            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String email = resultSet.getString("email");
            String genderStr = resultSet.getString("gender").toUpperCase();
            Student.Gender gender = Student.Gender.valueOf(genderStr);

            return new Student(
                studentId, 
                firstName, 
                lastName, 
                email, 
                gender
            );
        };
     }
    
}

// return List.of(
//             new Student(UUID.randomUUID(), "João", "Sousa", "joaosousa@gmail.com", Student.Gender.MALE),
//             new Student(UUID.randomUUID(), "Daniela", "Leão", "danielaleao@hotmail.com", Student.Gender.FEMALE)
//         );
