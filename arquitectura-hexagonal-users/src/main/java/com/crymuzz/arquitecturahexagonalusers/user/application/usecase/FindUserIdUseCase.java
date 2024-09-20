package com.crymuzz.arquitecturahexagonalusers.user.application.usecase;

import com.crymuzz.arquitecturahexagonalusers.user.domain.model.User;
import com.crymuzz.arquitecturahexagonalusers.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class FindUserIdUseCase {

    private final UserRepository userRepository;

    public Optional<User> findById(Long id) {
        return this.userRepository.findById(id);
    } 

}
