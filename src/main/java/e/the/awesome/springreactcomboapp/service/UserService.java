package e.the.awesome.springreactcomboapp.service;

import e.the.awesome.springreactcomboapp.model.User;
import e.the.awesome.springreactcomboapp.model.UserDto;
import java.util.List;

public interface UserService {

    User save(UserDto user);
    List<User> findAll();
    void delete(int id);

    User findOne(String username);

    User findById(int id);

    UserDto update(UserDto userDto);
}
