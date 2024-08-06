package com.crymuzz.arquitecturahexagonaltasks.application.usecase;

import com.crymuzz.arquitecturahexagonaltasks.domain.ports.in.DeleteTaskUseCase;
import com.crymuzz.arquitecturahexagonaltasks.domain.ports.out.TaskRepositoryPort;


public class DeleteTaskUseCaseImpl implements DeleteTaskUseCase {

    private final TaskRepositoryPort repositoryPort;

    public DeleteTaskUseCaseImpl(TaskRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public boolean deleteTask(Long id) {
        return repositoryPort.deleteById(id);
    }
}
