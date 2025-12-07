package com.sanskar.ecommerce.entity.party;

import com.sanskar.ecommerce.entity.order.OrderItem;
import com.sanskar.ecommerce.entity.order.OrderRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"email"}
        )
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;
    private String email;

    @OneToMany(mappedBy = "party")
    private List<OrderRole> orderRoles;
}
