package com.crymuzz.arquitecturahexagonaltasks.infrastructure.repository;

import com.crymuzz.arquitecturahexagonaltasks.domain.model.Task;
import com.crymuzz.arquitecturahexagonaltasks.domain.ports.out.TaskRepositoryPort;
import com.crymuzz.arquitecturahexagonaltasks.infrastructure.entity.TaskEntity;
import com.crymuzz.arquitecturahexagonaltasks.infrastructure.entity.mapper.TaskMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TaskRepositoryAdapter implements TaskRepositoryPort {

    private final TaskRepository repository;

    public TaskRepositoryAdapter(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public Task save(Task task) {
        System.out.println(task.toString());
        TaskEntity taskEntity = TaskMapper.INSTANCE.taskToTaskEntity(task);
        System.out.println(taskEntity);
        TaskEntity savedTaskEntity = repository.save(taskEntity);
        System.out.println(savedTaskEntity);
        return TaskMapper.INSTANCE.TaskEntityToTask(savedTaskEntity);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return repository.findById(id).map(TaskMapper.INSTANCE::TaskEntityToTask);
    }

    @Override
    public List<Task> findAll() {
        return repository.findAll().stream().map(TaskMapper.INSTANCE::TaskEntityToTask).toList();
    }

    @Override
    public Optional<Task> update(Long id, Task task) {
        if (repository.existsById(id)) {
            TaskEntity taskEntity = TaskMapper.INSTANCE.taskToTaskEntity(task);
            taskEntity.setId(id);
            TaskEntity updateTask = repository.save(taskEntity);
            return Optional.of(TaskMapper.INSTANCE.TaskEntityToTask(updateTask));
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
