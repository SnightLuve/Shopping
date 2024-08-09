package org.example.shopping.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.shopping.model.Size;
import org.example.shopping.repository.SizeRepository;
import org.example.shopping.service.SizeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SizeServiceImpl implements SizeService {
    private final SizeRepository sizeRepository;
    @Override
    public Size createSize(Size size) {
        return sizeRepository.save(size);
    }

    @Override
    public List<Size> getAllSizes() {
        return sizeRepository.findAll();
    }

    @Override
    public Size getSizeById(Long id) {
        return sizeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteSizeById(Long id) {
        sizeRepository.removeById(id);
    }

    @Override
    public Size updateSize(Size size) {
        Size s = sizeRepository.findById(size.getId()).orElse(null);
        return sizeRepository.save(s);
    }
}
