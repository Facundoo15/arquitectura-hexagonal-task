package com.crymuzz.arquitecturahexagonaltasks.application.usecase;

import com.crymuzz.arquitecturahexagonaltasks.domain.model.Task;
import com.crymuzz.arquitecturahexagonaltasks.domain.ports.in.RetrieveTaskUseCase;
import com.crymuzz.arquitecturahexagonaltasks.domain.ports.out.TaskRepositoryPort;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;


public class RetrieveTaskUseCaseImpl implements RetrieveTaskUseCase {

    private final TaskRepositoryPort repositoryPort;

    public RetrieveTaskUseCaseImpl(TaskRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Optional<Task> getTask(Long id) {
        return repositoryPort.findById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return repositoryPort.findAll();
    }
}
