package org.example.shopping.repository;

import jakarta.transaction.Transactional;
import org.example.shopping.model.Brand;
import org.example.shopping.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<Color, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Color c SET c.status=0 WHERE c.id=:id")
    void removeById(Long id);
}
