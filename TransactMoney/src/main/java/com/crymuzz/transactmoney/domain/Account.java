package com.crymuzz.transactmoney.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Account {

    private Long id;
    private BigDecimal amount;

    // Método para validar si un monto es correcto
    public Boolean isBalanceGreaterThan(BigDecimal otherAmount) {
        return this.amount.compareTo(otherAmount) > 0;
    }

    // Método para depositar un monto
    public void plus(BigDecimal amount) {
        this.amount = this.amount.add(amount);
    }
    // Método para retirar dinero
    public void subtract(BigDecimal amount) {
        this.amount = this.amount.subtract(amount);
    }

}
