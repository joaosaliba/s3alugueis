package br.com.s3alugueis.app.dto.authentication;

import jakarta.validation.constraints.NotNull;

public record AuthenticationRequest(
                @NotNull String email,
                @NotNull String password) {

}
