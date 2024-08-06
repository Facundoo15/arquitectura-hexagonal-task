package com.crymuzz.arquitecturahexagonaltasks.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AdditionalTaskInfo {

    private final Long userId;
    private final String username;
    private final String userEmail;


    public AdditionalTaskInfo(Long userId, String username, String userEmail) {
        this.userId = userId;
        this.username = username;
        this.userEmail = userEmail;
    }
}
