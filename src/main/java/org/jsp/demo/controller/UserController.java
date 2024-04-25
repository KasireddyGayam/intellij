package org.jsp.demo.controller;

import org.jsp.demo.model.User;
import org.jsp.demo.service.UserService;
import org.jsp.demo.util.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController
{
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<ResponseStructure<User>> save(User user)
    {
        return userService.save(user);
    }
    @PutMapping
    public ResponseEntity<ResponseStructure<User>>update(User user)
    {
        return userService.update(user);

    }
}
