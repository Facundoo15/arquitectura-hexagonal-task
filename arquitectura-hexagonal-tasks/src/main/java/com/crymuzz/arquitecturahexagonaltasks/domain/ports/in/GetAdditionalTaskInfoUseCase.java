package com.crymuzz.arquitecturahexagonaltasks.domain.ports.in;

import com.crymuzz.arquitecturahexagonaltasks.domain.model.AdditionalTaskInfo;

public interface GetAdditionalTaskInfoUseCase {
    AdditionalTaskInfo getAdditionalTaskInfo(Long id);
}
