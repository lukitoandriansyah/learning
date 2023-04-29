package com.ito.springbootrestfulwebservices.controller;

import com.ito.springbootrestfulwebservices.dto.UserDto;
import com.ito.springbootrestfulwebservices.exception.ErrorDetails;
import com.ito.springbootrestfulwebservices.exception.ResourceNotFoundException;
import com.ito.springbootrestfulwebservices.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@Tag(
        name = "CRUD REST APIs for User Resources",
        description = "Create, Update, Get, Get All, Delete User"
)
@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    @Operation(
            summary = "Create User",
            description = "Create User is used to save into database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http status 201 created"
    )
    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto userCreate = userService.createUser(userDto);
        return new ResponseEntity<>(userCreate, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get User by Id",
            description = "Get User by ID is used to get single user from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http status 200 success"
    )
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable Long id){
        UserDto userById = userService.getById(id);
        return new ResponseEntity<>(userById, HttpStatus.OK);
    }

    @Operation(
            summary = "Get all User",
            description = "Get all User is used to get all user from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http status 200 success"
    )
    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAll(){
        List<UserDto> userList = userService.getAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    @Operation(
            summary = "Update User",
            description = "Update User is used to update particular user to database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http status 200 success"
    )
    @PutMapping("/update/{id}")
    public ResponseEntity<UserDto> updateUserController(@PathVariable Long id, @RequestBody @Valid UserDto userDto){
        userDto.setId(id);
        UserDto userUpdate = userService.updateUser(userDto);
        return new ResponseEntity<>(userUpdate, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete User",
            description = "Delete User is used to delete particular user to database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http status 200 success"
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>("Deleted Successfully for id: "+id, HttpStatus.OK);
    }

    /*@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException,
                                                                        WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(
                LocalDateTime.now(),
                resourceNotFoundException.getMessage(),
                webRequest.getDescription(false),
                "USER_NOT_FOUND"

        );
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }*/
}
