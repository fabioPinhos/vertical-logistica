package br.com.luizalabs.verticallogistica.core.domain.dto;

import java.util.List;

public record UserDto(int user_id, String name, List<OrderDto> orders) {
}
