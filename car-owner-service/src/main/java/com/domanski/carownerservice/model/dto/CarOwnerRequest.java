package com.domanski.carownerservice.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record CarOwnerRequest(
        @NotNull
        @NotBlank
        String name,
        @NotNull
        @NotBlank
        String surname,
        @NotNull
        @NotBlank
        @Email
        String email,
        @NotNull
        @NotBlank
        @Length(min = 9, max = 9)
        String phone) {
}
