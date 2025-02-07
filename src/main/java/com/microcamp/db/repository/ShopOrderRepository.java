package com.microcamp.db.repository;

import com.microcamp.db.domain.ShopOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopOrderRepository extends JpaRepository<ShopOrder, Long> {
    @Query("SELECT so FROM ShopOrder so where so.customer.id = ?1")
    List<ShopOrder> findByCustomerId(Long customerId);

    @Query("SELECT so FROM ShopOrder so join fetch so.customer")
    Page<ShopOrder> findAllWithCustomer(Pageable pageable);
}
