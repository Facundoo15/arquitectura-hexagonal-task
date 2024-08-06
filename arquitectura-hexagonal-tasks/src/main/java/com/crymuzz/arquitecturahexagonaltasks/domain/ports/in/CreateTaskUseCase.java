    package com.crymuzz.arquitecturahexagonaltasks.domain.ports.in;

    import com.crymuzz.arquitecturahexagonaltasks.domain.model.Task;

    public interface CreateTaskUseCase {
        Task createTask(Task task);
    }
