package br.com.luizalabs.verticallogistica.core.domain.dto;

import java.util.List;

public record UserDto(long user_id, String name, List<OrderDto> orders) {
}
