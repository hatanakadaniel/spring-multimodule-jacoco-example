package com.hatanaka.springmultimodulejacocoexample.domain;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class DomainA {

    private String param1;
    private BigDecimal param2;
}
