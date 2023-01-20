package br.com.microservice.statefulanyapi.core.dto;

public record AnyResponse(String status, Integer code, AuthUserResponse authUser) {
}
