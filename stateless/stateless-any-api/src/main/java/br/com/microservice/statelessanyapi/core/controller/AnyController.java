package br.com.microservice.statelessanyapi.core.controller;

import br.com.microservice.statelessanyapi.core.dto.AnyResponse;
import br.com.microservice.statelessanyapi.core.service.AnyService;
import br.com.microservice.statelessanyapi.core.service.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@AllArgsConstructor
@RequestMapping("api/resource")
public class AnyController {

    private final AnyService service;

    @GetMapping
    public AnyResponse getResource(@RequestHeader String accessToken) {
        return service.getData(accessToken);
    }
}
