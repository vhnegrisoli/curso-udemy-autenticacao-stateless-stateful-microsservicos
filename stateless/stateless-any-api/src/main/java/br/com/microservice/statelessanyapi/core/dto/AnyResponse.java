package br.com.microservice.statelessanyapi.core.dto;

public record AnyResponse(String status, Integer code, AuthUserResponse authUser) {
}
