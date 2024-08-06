package com.crymuzz.arquitecturahexagonaltasks.domain.ports.out;

import com.crymuzz.arquitecturahexagonaltasks.domain.model.AdditionalTaskInfo;

public interface ExternalServicePort {
    AdditionalTaskInfo getAdditionalTaskInfo(Long taskId);
}
