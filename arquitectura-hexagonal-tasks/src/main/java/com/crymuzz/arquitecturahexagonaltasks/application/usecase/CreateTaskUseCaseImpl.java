package com.crymuzz.arquitecturahexagonaltasks.application.usecase;

import com.crymuzz.arquitecturahexagonaltasks.domain.model.Task;
import com.crymuzz.arquitecturahexagonaltasks.domain.ports.in.CreateTaskUseCase;
import com.crymuzz.arquitecturahexagonaltasks.domain.ports.out.TaskRepositoryPort;

public class CreateTaskUseCaseImpl implements CreateTaskUseCase {

    private final TaskRepositoryPort repositoryPort;

    public CreateTaskUseCaseImpl(TaskRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Task createTask(Task task) {
        return repositoryPort.save(task);
    }
}
