package com.crymuzz.auditexampleproduct.service;

import com.crymuzz.auditexampleproduct.entity.dto.ProductDTO;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;

public interface IProductListener {

    @PrePersist
    void prePersist(ProductDTO product);
    @PreUpdate
    void preUpdate(ProductDTO product);
    @PreRemove
    void preRemove(ProductDTO product);


}
