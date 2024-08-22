package br.com.luizalabs.verticallogistica.core.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity(name = "products")
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Products {

    @Id
    private Long product_id;
    private BigDecimal value;

    @OneToMany(mappedBy = "order_id", cascade = CascadeType.ALL)
    private List<Orders> orders;
}
