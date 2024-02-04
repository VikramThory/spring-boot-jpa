package com.vikram.singh.springbootjpa.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record StudentDto(@NotEmpty(message = "Student name can not be empty")
                         @Size(min = 1, max = 30, message = "The length of Student name should be between 1 to 30")
                         String name,
                         int standard,
                         @NotEmpty(message = "Student section can not be empty")
                         String section) {
}
