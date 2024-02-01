package org.jt.user.UserService.service;

import org.jt.user.UserService.entities.User;

import java.util.List;

public interface UserService {
    User saveUsers(User user);
    List<User> getAllUsers();
    User getUser(String userId);
//    Optional<User>updateById(String userId);
//    void deleteById(String userId);
}
