package org.example.shopping.repository;

import org.example.shopping.model.Brand;
import org.example.shopping.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<Color, Long> {
}
