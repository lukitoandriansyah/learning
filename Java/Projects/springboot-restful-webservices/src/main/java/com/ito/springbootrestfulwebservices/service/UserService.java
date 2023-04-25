package com.ito.springbootrestfulwebservices.service;

import com.ito.springbootrestfulwebservices.dto.UserDto;
import com.ito.springbootrestfulwebservices.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto user);

    UserDto getById(Long id);

    List<UserDto> getAll();

    UserDto updateUser(UserDto userDto);

    void deleteUser(Long id);
}
