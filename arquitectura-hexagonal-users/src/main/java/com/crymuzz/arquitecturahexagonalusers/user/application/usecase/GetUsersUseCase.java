package com.crymuzz.arquitecturahexagonalusers.user.application.usecase;

import com.crymuzz.arquitecturahexagonalusers.user.domain.model.User;
import com.crymuzz.arquitecturahexagonalusers.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GetUsersUseCase {

    private final UserRepository userRepository;

    public List<User> getAllUsers(){
        return this.userRepository.getAllUsers();
    }

}
