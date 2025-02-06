package com.microcamp.db.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Table(name = "CUSTOMER")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    public Customer(String name, String uniqueKey, Instant dateBirth) {
        this.name = name;
        this.uniqueKey = uniqueKey;
        this.dateBirth = dateBirth;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, name = "NAME_CUSTOMER",
            length = 20
//            ,
//            columnDefinition = "VARCHAR2(100)"
    )
    private String name;

    @Column(nullable = false, length = 25, unique = true )
    private String uniqueKey;

    @Column
    private Instant dateBirth;

    @Transient
    private String noVisibleField;

    @OneToMany(mappedBy = "customer")
    List<ShopOrder> shopOrders;
}
