package br.com.s3alugueis.app.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.s3alugueis.app.model.User;

public interface UserRepository  extends JpaRepository<User, Long> {
    
    Optional<User> findByEmail(String email);
    
}
