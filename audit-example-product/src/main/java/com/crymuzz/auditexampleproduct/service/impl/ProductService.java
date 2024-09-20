package com.crymuzz.auditexampleproduct.service.impl;

import com.crymuzz.auditexampleproduct.entity.ProductEntity;
import com.crymuzz.auditexampleproduct.entity.dto.ProductDTO;
import com.crymuzz.auditexampleproduct.entity.mapper.ProductMapper;
import com.crymuzz.auditexampleproduct.repository.ProductRepository;
import com.crymuzz.auditexampleproduct.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository productRepository;


    @Override
    public ProductDTO save(ProductDTO productDTO) {
        System.out.println(productDTO.toString());
        ProductEntity productEntity = ProductMapper.INSTANCE.toProduct(productDTO);
        System.out.println(productEntity.toString());
        ProductEntity saved = this.productRepository.save(productEntity);
        return ProductMapper.INSTANCE.toProductDTO(saved);
    }

    @Override
    public ProductDTO update(Long id, ProductDTO productDTO) {

        ProductEntity productEntity = this.productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        ProductEntity productUpdate =  productRepository.save(productEntity);
        return ProductMapper.INSTANCE.toProductDTO(productUpdate);
    }

    @Override
    public List<ProductDTO> findAll() {
        return ProductMapper.INSTANCE.toProductDTOList(productRepository.findAll());
    }

    @Override
    public void delete(Long id) {
        this.productRepository.deleteById(id);
    }
}
