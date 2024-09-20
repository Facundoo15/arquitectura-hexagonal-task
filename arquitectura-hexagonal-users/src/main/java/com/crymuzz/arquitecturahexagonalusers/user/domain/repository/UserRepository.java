package com.crymuzz.arquitecturahexagonalusers.user.domain.repository;

import com.crymuzz.arquitecturahexagonalusers.user.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User create(User user);
    List<User> getAllUsers();
    Optional<User> findById(Long id);
    User update(Long id, User user);
    void deleteUserById(Long id);
}
