package br.com.microservice.statefulanyapi.core.controller;

import br.com.microservice.statefulanyapi.core.service.TokenService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@AllArgsConstructor
@RequestMapping("api/resource")
public class AppController {

    private final TokenService tokenService;

    @GetMapping
    public HashMap<String, Object> getResource(@RequestHeader String token) {
        tokenService.validateToken(token);
        var data = new HashMap<String, Object>();
        data.put("status", "Ok!");
        data.put("success", true);
        data.put("code", 200);
        var authUser = tokenService.getAuthUser(token);
        data.put("id", authUser.id());
        data.put("username", authUser.username());
        return data;
    }
}
