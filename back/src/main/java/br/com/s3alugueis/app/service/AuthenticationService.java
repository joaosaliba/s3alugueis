package br.com.s3alugueis.app.service;

import br.com.s3alugueis.app.enums.AuthProvider;
import br.com.s3alugueis.app.enums.UserRole;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.s3alugueis.app.dto.authentication.AuthenticationRequest;
import br.com.s3alugueis.app.dto.authentication.AuthenticationResponse;
import br.com.s3alugueis.app.dto.register.RegisterRequest;
import br.com.s3alugueis.app.entities.User;
import br.com.s3alugueis.app.repository.UserRepository;
import br.com.s3alugueis.app.util.JwtUtil;

import java.time.Instant;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final JwtUtil jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtService,
            AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(RegisterRequest request) {
        User user = new User();
        user.setName(request.name().trim());
        user.setEmail(request.email().trim());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setRole(UserRole.ROLE_ADMIN);
        user.setProvider(AuthProvider.local);
        user.setCreatedDate(Instant.now());
        user.setModifiedDate(Instant.now());
        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponse(jwtToken);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()));
        User user = userRepository.findByEmail(request.email()).orElseThrow();
        String jwtToken = jwtService.generateToken(user);
        return new AuthenticationResponse(jwtToken);
    }

}
