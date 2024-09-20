package com.crymuzz.arquitecturahexagonalusers.user.application.usecase;

import com.crymuzz.arquitecturahexagonalusers.user.domain.model.User;
import com.crymuzz.arquitecturahexagonalusers.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateUserUseCase {

    private final UserRepository userRepository;

    public User createUser(User user) {
        return this.userRepository.create(user);
    }


}
