package com.crymuzz.arquitecturahexagonaltasks.infrastructure.entity.mapper;

import com.crymuzz.arquitecturahexagonaltasks.domain.model.Task;
import com.crymuzz.arquitecturahexagonaltasks.infrastructure.entity.TaskEntity;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapper;

@Mapper
public interface TaskMapper {
    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    TaskEntity taskToTaskEntity(Task task);
    Task TaskEntityToTask(TaskEntity entity);

}
