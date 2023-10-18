package com.franklanches.repositories;

import com.franklanches.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("""
SELECT SalesItem FROM Order o WHERE o.id= :orderId

""")
    List<String> getSalesItems(Long orderId);
}

