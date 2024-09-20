package com.crymuzz.auditexampleproduct.service.impl;

import com.crymuzz.auditexampleproduct.entity.HistoryEntity;
import com.crymuzz.auditexampleproduct.entity.dto.ProductDTO;
import com.crymuzz.auditexampleproduct.repository.HistoryRepository;
import com.crymuzz.auditexampleproduct.service.IProductListener;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Component
public class HistoryListenerService implements IProductListener {

    private final HistoryRepository historyRepository;

    public HistoryListenerService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    public void prePersist(ProductDTO product) {
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        HistoryEntity history = new HistoryEntity();
        history.setName(product.getName());
        history.setDate(LocalDateTime.now());
        history.setOperation("INSERT");
        history.setUsername(user);
        this.historyRepository.save(history);

    }

    @Override
    public void preUpdate(ProductDTO product) {
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        HistoryEntity history = new HistoryEntity();
        history.setName(product.getName());
        history.setDate(LocalDateTime.now());
        history.setOperation("UPDATE");
        history.setUsername(user);
        this.historyRepository.save(history);
    }

    @Override
    public void preRemove(ProductDTO product) {
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        HistoryEntity history = new HistoryEntity();
        history.setName(product.getName());
        history.setDate(LocalDateTime.now());
        history.setOperation("DELETE");
        history.setUsername(user);
        this.historyRepository.save(history);
    }
}
