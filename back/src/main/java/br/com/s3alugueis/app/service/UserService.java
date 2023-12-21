package br.com.s3alugueis.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.s3alugueis.app.dto.user.UserList;
import br.com.s3alugueis.app.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Page<UserList> listUser(Pageable pageble) {
        return userRepository.findAllAsUserList(pageble);
    }

}
