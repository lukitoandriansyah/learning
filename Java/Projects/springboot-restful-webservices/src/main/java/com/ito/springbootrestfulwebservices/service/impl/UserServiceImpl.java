package com.ito.springbootrestfulwebservices.service.impl;

import com.ito.springbootrestfulwebservices.dto.UserDto;
import com.ito.springbootrestfulwebservices.entity.User;
import com.ito.springbootrestfulwebservices.exception.EmailAlreadyExistException;
import com.ito.springbootrestfulwebservices.exception.ResourceNotFoundException;
import com.ito.springbootrestfulwebservices.mapper.AutoUserMapper;
import com.ito.springbootrestfulwebservices.repository.UserRepository;
import com.ito.springbootrestfulwebservices.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto userDto) {
        Optional<User> userOptional = userRepository.findByEmail(userDto.getEmail());
        if(userOptional.isPresent()){
            throw new EmailAlreadyExistException("Email Already Exist for Use");
        }
        //User userEntity = UserMapper.mapToUser(userDto);
        //User userEntity = modelMapper.map(userDto, User.class);
        User userEntity = AutoUserMapper.MAPPER.mapToUser(userDto);
        User userSave = userRepository.save(userEntity);
        //UserDto userDtoSave = UserMapper.mapToUserDto(userSave);
        //UserDto userDtoSave = modelMapper.map(userSave, UserDto.class);
        UserDto userDtoSave = AutoUserMapper.MAPPER.mapToUserDto(userSave);

        return userDtoSave;
    }

    @Override
    public UserDto getById(Long id) {
        User userFind = userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User", "Id", id));
        //User user = optionalUser.get();
        //return  UserMapper.mapToUserDto(user);
        //return  modelMapper.map(user, UserDto.class);
        return  AutoUserMapper.MAPPER.mapToUserDto(userFind);
    }

    @Override
    public List<UserDto> getAll() {
        List<User> userList = userRepository.findAll();
        //return userList.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
        //return userList.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
        return userList.stream().map(user -> AutoUserMapper.MAPPER.mapToUserDto(user)).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User userExisting = userRepository.findById(userDto.getId())
                .orElseThrow(()->new ResourceNotFoundException("User", "Id", userDto.getId()));
        userExisting.setFirstName(userDto.getFirstName());
        userExisting.setLastName(userDto.getLastName());
        userExisting.setEmail(userDto.getEmail());
        User userUpdate = userRepository.save(userExisting);
        //return UserMapper.mapToUserDto(userUpdate);
        //return modelMapper.map(userUpdate, UserDto.class);
        return AutoUserMapper.MAPPER.mapToUserDto(userUpdate);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User", "Id", id));
        userRepository.deleteById(id);
    }


}
