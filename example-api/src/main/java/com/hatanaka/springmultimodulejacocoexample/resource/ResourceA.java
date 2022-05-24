package com.hatanaka.springmultimodulejacocoexample.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceA {

    @GetMapping
    public ResponseEntity<String> resourceAMethod(@RequestParam final String param1,
                                                  @RequestParam final String param2) {
        return ResponseEntity.ok("");
    }
}
