package com.crymuzz.arquitecturahexagonaltasks.application.usecase;

import com.crymuzz.arquitecturahexagonaltasks.domain.model.AdditionalTaskInfo;
import com.crymuzz.arquitecturahexagonaltasks.domain.ports.in.GetAdditionalTaskInfoUseCase;
import com.crymuzz.arquitecturahexagonaltasks.domain.ports.out.ExternalServicePort;
import lombok.AllArgsConstructor;

public class GetAdditionalTaskInfoUseCaseImpl implements GetAdditionalTaskInfoUseCase {

    private final ExternalServicePort externalServicePort;

    public GetAdditionalTaskInfoUseCaseImpl(ExternalServicePort externalServicePort) {
        this.externalServicePort = externalServicePort;
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return externalServicePort.getAdditionalTaskInfo(id);
    }
}
