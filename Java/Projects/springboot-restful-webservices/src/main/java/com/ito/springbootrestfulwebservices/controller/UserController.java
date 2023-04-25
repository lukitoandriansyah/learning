package com.ito.springbootrestfulwebservices.controller;

import com.ito.springbootrestfulwebservices.dto.UserDto;
import com.ito.springbootrestfulwebservices.entity.User;
import com.ito.springbootrestfulwebservices.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto userCreate = userService.createUser(userDto);
        return new ResponseEntity<>(userCreate, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Long id){
        UserDto userById = userService.getById(id);
        return new ResponseEntity<>(userById, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAll(){
        List<UserDto> userList = userService.getAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDto> updateUserController(@PathVariable Long id, @RequestBody UserDto userDto){
        userDto.setId(id);
        UserDto userUpdate = userService.updateUser(userDto);
        return new ResponseEntity<>(userUpdate, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>("Deleted Successfully for id: "+id, HttpStatus.OK);
    }
}
