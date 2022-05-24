package com.hatanaka.springmultimodulejacocoexample.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DomainB {

    private String param1;
    private Long param2;
    private String param3;
}
