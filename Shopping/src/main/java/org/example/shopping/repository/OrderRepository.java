package org.example.shopping.repository;

import org.example.shopping.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Modifying
    @Query("UPDATE Order o SET o.totalMoney=:totalMoney," +
            " o.quantity=:quantity WHERE o.id=:id")
    void updateOrder(Double totalMoney, Integer quantity, Long id);

    @Query("SELECT o FROM Order o WHERE o.status=1")
    Page<Order> getAll(Pageable pageable);

    @Query("UPDATE Order o SET o.status=2 WHERE o.id=:id")
    void delete(Long id);
}
