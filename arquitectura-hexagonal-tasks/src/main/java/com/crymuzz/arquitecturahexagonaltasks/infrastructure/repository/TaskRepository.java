package com.crymuzz.arquitecturahexagonaltasks.infrastructure.repository;

import com.crymuzz.arquitecturahexagonaltasks.infrastructure.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {


}
