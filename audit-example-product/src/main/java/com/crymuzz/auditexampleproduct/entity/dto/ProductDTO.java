package com.crymuzz.auditexampleproduct.entity.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    @NotBlank(message = "El nombre del producto no puede ser nulo o vacio")
    private String name;
    @NotBlank(message = "La descripción no puede ser nula o vacia")
    private String description;
    @Digits(integer = 4, fraction = 2)
    private Double price;

}
