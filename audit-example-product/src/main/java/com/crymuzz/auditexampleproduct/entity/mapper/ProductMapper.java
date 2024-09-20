package com.crymuzz.auditexampleproduct.entity.mapper;

import com.crymuzz.auditexampleproduct.entity.ProductEntity;
import com.crymuzz.auditexampleproduct.entity.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductEntity toProduct(ProductDTO productDTO);

    ProductDTO toProductDTO(ProductEntity productEntity);

    List<ProductDTO> toProductDTOList(List<ProductEntity> productEntityList);
}
