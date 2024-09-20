package com.crymuzz.transactmoney;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class InsertTable implements InitializingBean {

    private final SpringAccountRepository insert;

    @Override
    public void afterPropertiesSet() throws Exception {
        this.insert.save(new AccountEntity(1L, BigDecimal.valueOf(50)));
        this.insert.save(new AccountEntity(2L, BigDecimal.valueOf(40)));
        this.insert.save(new AccountEntity(3L, BigDecimal.valueOf(70)));
    }
}
