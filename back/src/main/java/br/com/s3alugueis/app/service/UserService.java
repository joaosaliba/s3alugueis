package br.com.s3alugueis.app.service;

import br.com.s3alugueis.app.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.s3alugueis.app.dto.user.UserList;
import br.com.s3alugueis.app.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Page<UserList> listUser(Pageable pageble) {
        return userRepository.findAllAsUserList(pageble);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User save(User userEntity) {
        return userRepository.save(userEntity);
    }

    public User update(User existingUserDTO) {
         return userRepository.save(existingUserDTO);
    }
}
