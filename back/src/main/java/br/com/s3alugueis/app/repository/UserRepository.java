package br.com.s3alugueis.app.repository;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.s3alugueis.app.dto.user.UserList;
import br.com.s3alugueis.app.model.User;

public interface UserRepository  extends JpaRepository<User, Long> {
    
    Optional<User> findByEmail(String email);

    @Query("Select new br.com.s3alugueis.app.dto.user.UserList(u.id, u.name, u.email) from User u")
    Page<UserList> findAllAsUserList(Pageable pageble);
    
}
