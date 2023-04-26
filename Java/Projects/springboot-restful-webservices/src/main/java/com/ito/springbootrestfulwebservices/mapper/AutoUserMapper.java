package com.ito.springbootrestfulwebservices.mapper;

import com.ito.springbootrestfulwebservices.dto.UserDto;
import com.ito.springbootrestfulwebservices.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {
    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

    //@Mapping(source = "email", target = "email")
    UserDto mapToUserDto(User user);
    User mapToUser(UserDto userDto);
}
