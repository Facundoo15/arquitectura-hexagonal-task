package com.crymuzz.arquitecturahexagonaltasks.infrastructure.config;

import com.crymuzz.arquitecturahexagonaltasks.application.service.TaskService;
import com.crymuzz.arquitecturahexagonaltasks.application.usecase.*;
import com.crymuzz.arquitecturahexagonaltasks.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.crymuzz.arquitecturahexagonaltasks.domain.ports.out.ExternalServicePort;
import com.crymuzz.arquitecturahexagonaltasks.domain.ports.out.TaskRepositoryPort;
import com.crymuzz.arquitecturahexagonaltasks.infrastructure.adapter.ExternalServiceAdapter;
import com.crymuzz.arquitecturahexagonaltasks.infrastructure.repository.TaskRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public TaskService taskService(TaskRepositoryPort taskRepositoryPort,
                                   GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
        return new TaskService(
                new CreateTaskUseCaseImpl(taskRepositoryPort),
                new DeleteTaskUseCaseImpl(taskRepositoryPort),
                getAdditionalTaskInfoUseCase,
                new RetrieveTaskUseCaseImpl(taskRepositoryPort),
                new UpdateTaskUseCaseImpl(taskRepositoryPort)
        );
    }

    @Bean
    public TaskRepositoryPort taskRepositoryPort(TaskRepositoryAdapter taskRepositoryAdapter) {
        return taskRepositoryAdapter;
    }

    @Bean
    public GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase(ExternalServicePort externalServicePort) {
        return new GetAdditionalTaskInfoUseCaseImpl(externalServicePort);
    }

    @Bean
    public ExternalServicePort externalServicePort() {
        return new ExternalServiceAdapter();
    }

}
