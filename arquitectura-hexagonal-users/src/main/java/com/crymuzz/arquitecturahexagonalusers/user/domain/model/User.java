package com.crymuzz.arquitecturahexagonalusers.user.domain.model;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User {

    private Long id;
    private String name;
    private String email;
    private LocalDate createdAt;

}
