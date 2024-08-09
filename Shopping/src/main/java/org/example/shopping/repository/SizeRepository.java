package org.example.shopping.repository;

import jakarta.transaction.Transactional;
import org.example.shopping.model.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeRepository extends JpaRepository<Size, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Size s SET s.status=0 WHERE s.id=:id")
    void removeById(Long id);
}
