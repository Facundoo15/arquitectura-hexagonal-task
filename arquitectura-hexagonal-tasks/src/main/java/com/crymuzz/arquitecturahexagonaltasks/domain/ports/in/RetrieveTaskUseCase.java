package com.crymuzz.arquitecturahexagonaltasks.domain.ports.in;

import com.crymuzz.arquitecturahexagonaltasks.domain.model.Task;

import java.util.List;
import java.util.Optional;

public interface RetrieveTaskUseCase {
    Optional<Task> getTask(Long id);
    List<Task> getAllTasks();
}
