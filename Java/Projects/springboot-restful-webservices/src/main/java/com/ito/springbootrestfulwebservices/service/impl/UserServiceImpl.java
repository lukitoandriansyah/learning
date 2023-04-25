package com.ito.springbootrestfulwebservices.service.impl;

import com.ito.springbootrestfulwebservices.dto.UserDto;
import com.ito.springbootrestfulwebservices.entity.User;
import com.ito.springbootrestfulwebservices.mapper.UserMapper;
import com.ito.springbootrestfulwebservices.repository.UserRepository;
import com.ito.springbootrestfulwebservices.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        User userEntity = UserMapper.mapToUser(userDto);
        User userSave = userRepository.save(userEntity);
        UserDto userDtoSave = UserMapper.mapToUserDto(userSave);
        return userDtoSave;
    }

    @Override
    public UserDto getById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.get();
        return  UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAll() {
        List<User> userList = userRepository.findAll();
        return userList.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User userExisting = userRepository.findById(userDto.getId()).get();
        userExisting.setFirstName(userDto.getFirstName());
        userExisting.setLastName(userDto.getLastName());
        userExisting.setEmail(userDto.getEmail());
        User userUpdate = userRepository.save(userExisting);
        return UserMapper.mapToUserDto(userUpdate);


    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


}
