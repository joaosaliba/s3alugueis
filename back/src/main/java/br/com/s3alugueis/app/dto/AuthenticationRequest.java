package br.com.s3alugueis.app.dto;

import jakarta.validation.constraints.NotNull;

public record AuthenticationRequest(
                @NotNull String email,
                @NotNull String password) {

}
