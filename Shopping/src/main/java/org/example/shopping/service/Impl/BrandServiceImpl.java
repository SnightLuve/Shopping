package org.example.shopping.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.shopping.model.Brand;
import org.example.shopping.repository.BrandRepository;
import org.example.shopping.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;
    @Override
    public Brand createBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public Brand getBrandById(Long id) {
        return brandRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteBrandById(Long id) {
        brandRepository.removeById(id);
    }

    @Override
    public Brand updateBrand(Brand brand) {
        Brand b = brandRepository.findById(brand.getId()).orElse(null);
        return brandRepository.save(b);
    }
}
