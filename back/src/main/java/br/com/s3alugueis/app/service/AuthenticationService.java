package br.com.s3alugueis.app.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.s3alugueis.app.dto.AuthenticationRequest;
import br.com.s3alugueis.app.dto.AuthenticationResponse;
import br.com.s3alugueis.app.dto.RegisterRequest;
import br.com.s3alugueis.app.model.User;
import br.com.s3alugueis.app.repository.UserRepository;
import br.com.s3alugueis.app.util.JwtUtil;

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
                user.setName(request.name());
                user.setEmail(request.email());
               user .setPassword(passwordEncoder.encode(request.password()));
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
