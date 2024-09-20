package ru.ekorzunov.urfu_bach_prog_3.lr8.service;

import org.springframework.stereotype.Service;
import ru.ekorzunov.urfu_bach_prog_3.lr8.dto.UserDto;
import ru.ekorzunov.urfu_bach_prog_3.lr8.entity.User;

import java.util.List;

@Service
public interface UserService {

    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();

}
