package br.com.luizalabs.verticallogistica.core.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "users")
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    private Long user_id;
    private String name;

    @OneToMany(mappedBy = "order_id", cascade = CascadeType.ALL)
    private List<Orders> orders;

}
