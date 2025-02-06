package com.microcamp.db.repository;

import com.microcamp.db.domain.ShopOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopOrderRepository extends JpaRepository<ShopOrder, Long> {
    List<ShopOrder> findByCustomerId(Long customerId);
}
