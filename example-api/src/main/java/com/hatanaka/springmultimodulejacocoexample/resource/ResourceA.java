package com.hatanaka.springmultimodulejacocoexample.resource;

import com.hatanaka.springmultimodulejacocoexample.domain.DomainA;
import com.hatanaka.springmultimodulejacocoexample.domain.DomainB;
import com.hatanaka.springmultimodulejacocoexample.service.ServiceA;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ResourceA {

    private final ServiceA serviceA;

    @GetMapping
    public ResponseEntity<DomainB> resourceAMethod(@RequestParam final String param1,
                                                   @RequestParam final BigDecimal param2) {
        log.info("m=resourceAMethod, param1={}, param2={}", param1, param2);
        final DomainA domainA = DomainA.builder()
                .param1(param1)
                .param2(param2)
                .build();
        return ResponseEntity.ok(serviceA.serviceAMethod(domainA));
    }
}
