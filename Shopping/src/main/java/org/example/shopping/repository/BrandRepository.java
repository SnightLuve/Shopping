package org.example.shopping.repository;

import jakarta.transaction.Transactional;
import org.example.shopping.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Brand b SET b.status=0 WHERE b.id=:id")
    void removeById(Long id);

}
