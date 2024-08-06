package com.crymuzz.arquitecturahexagonaltasks.application.usecase;

import com.crymuzz.arquitecturahexagonaltasks.domain.model.Task;
import com.crymuzz.arquitecturahexagonaltasks.domain.ports.in.UpdateTaskUseCase;
import com.crymuzz.arquitecturahexagonaltasks.domain.ports.out.TaskRepositoryPort;
import lombok.AllArgsConstructor;

import java.util.Optional;


public class UpdateTaskUseCaseImpl implements UpdateTaskUseCase {

    private final TaskRepositoryPort repositoryPort;

    public UpdateTaskUseCaseImpl(TaskRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Optional<Task> updateTask(Long id, Task updatedTask) {
        return repositoryPort.update(id, updatedTask);
    }
}
