package org.example.shopping.service;

import org.example.shopping.model.Brand;

import java.util.List;

public interface BrandService {
    Brand createBrand(Brand brand);
    List<Brand> getAllBrands();
    Brand getBrandById(Long id);
    void deleteBrandById(Long id);
    Brand updateBrand(Brand brand);
}
