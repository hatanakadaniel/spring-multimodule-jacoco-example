package com.hatanaka.springmultimodulejacocoexample.service;

import com.hatanaka.springmultimodulejacocoexample.domain.DomainA;
import com.hatanaka.springmultimodulejacocoexample.domain.DomainB;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class ServiceA {

    public DomainB serviceAMethod(final DomainA domainA) {
        return Optional.ofNullable(domainA)
                .filter(domainA1 -> domainA1.getParam2().compareTo(BigDecimal.TEN) < 1)
                .map(this::toDomainB)
                .orElse(DomainB.builder()
                                .param1("param1")
                                .param2(0L)
                                .param3("param3")
                                .build());
    }

    private DomainB toDomainB(final DomainA domainA) {
        return DomainB.builder()
                .param1(domainA.getParam1())
                .param2(domainA.getParam2().longValue())
                .param3("param3")
                .build();
    }
}
