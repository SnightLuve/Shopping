package org.example.shopping.repository;

import org.example.shopping.model.Brand;
import org.example.shopping.model.Sole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoleRepository extends JpaRepository<Sole, Long> {
}
