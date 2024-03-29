package br.com.s3alugueis.app.dto.register;

import jakarta.validation.constraints.NotBlank;

public record RegisterRequest(
        @NotBlank String name,
        @NotBlank String email,
        @NotBlank String password) {

}
