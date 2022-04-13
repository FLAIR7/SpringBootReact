package com.project.demo;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class EmailValidatorTest {
    
    private final EmailValidator underTest = new EmailValidator();

    @Test
    public void validateCorrectEmail() {
        assertThat(underTest.test("test@gmail.com")).isTrue();
    }

    @Test
    public void validateIncorretEmail() {
        assertThat(underTest.test("testgmail.com")).isFalse();
    }

    @Test
    public void validateIncorretEmailWithoutDot() {
        assertThat(underTest.test("test@gmailcom")).isFalse();
    }

}
