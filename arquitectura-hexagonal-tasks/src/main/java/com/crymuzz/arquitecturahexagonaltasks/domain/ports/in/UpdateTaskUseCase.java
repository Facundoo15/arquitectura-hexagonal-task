package com.crymuzz.arquitecturahexagonaltasks.domain.ports.in;

import com.crymuzz.arquitecturahexagonaltasks.domain.model.Task;

import java.util.Optional;

public interface UpdateTaskUseCase {
    Optional<Task> updateTask(Long id, Task updatedTask);
}
