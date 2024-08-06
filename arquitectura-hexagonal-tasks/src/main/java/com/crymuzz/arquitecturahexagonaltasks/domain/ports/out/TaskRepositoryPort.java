package com.crymuzz.arquitecturahexagonaltasks.domain.ports.out;

import com.crymuzz.arquitecturahexagonaltasks.domain.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepositoryPort {
    Task save(Task task);
    Optional<Task> findById(Long id);
    List<Task> findAll();
    Optional<Task> update(Long id,Task task);
    boolean deleteById(Long id);
}
