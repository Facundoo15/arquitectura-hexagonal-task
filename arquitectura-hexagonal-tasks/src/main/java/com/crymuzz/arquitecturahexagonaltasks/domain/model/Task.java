package com.crymuzz.arquitecturahexagonaltasks.domain.model;

import lombok.*;

import java.time.LocalDateTime;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Task {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private boolean completed;




}
