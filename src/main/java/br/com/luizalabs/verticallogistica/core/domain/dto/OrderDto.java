package br.com.luizalabs.verticallogistica.core.domain.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public record OrderDto(Integer oder_id, BigDecimal total, Date date, List<ProductsDto> products) {

}
