package com.project.demo;

import java.util.function.Predicate;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class EmailValidator implements Predicate<String>{

    private final Predicate<String> VALID_EMAIL = 
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", 
            Pattern.CASE_INSENSITIVE
            ).asPredicate(); 

    @Override
    public boolean test(String email) {
        // TODO Auto-generated method stub 
        return VALID_EMAIL.test(email);
    }
    
    
}
