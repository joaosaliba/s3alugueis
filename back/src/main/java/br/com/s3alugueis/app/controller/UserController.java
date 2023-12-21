package br.com.s3alugueis.app.controller;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.s3alugueis.app.dto.user.UserList;
import br.com.s3alugueis.app.service.UserService;

@RestController("user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<Page<UserList>> listUser(@ParameterObject Pageable pageable) {
        return ResponseEntity.ok(userService.listUser(pageable));
    }
}
