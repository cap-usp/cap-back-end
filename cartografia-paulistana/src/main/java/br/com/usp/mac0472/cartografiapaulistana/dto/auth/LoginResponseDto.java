package br.com.usp.mac0472.cartografiapaulistana.dto.auth;

import java.util.List;

public record LoginResponseDto(List<String> role, String token) {

}
