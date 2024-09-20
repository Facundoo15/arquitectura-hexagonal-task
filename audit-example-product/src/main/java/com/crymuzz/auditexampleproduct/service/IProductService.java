package com.crymuzz.auditexampleproduct.service;

import com.crymuzz.auditexampleproduct.entity.dto.ProductDTO;

import java.util.List;

    public interface IProductService {

        ProductDTO save(ProductDTO productDTO);
        ProductDTO update(Long id, ProductDTO productDTO);
        List<ProductDTO> findAll();
        void delete(Long id);

    }
