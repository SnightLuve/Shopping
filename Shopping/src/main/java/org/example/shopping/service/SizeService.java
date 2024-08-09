package org.example.shopping.service;

import org.example.shopping.model.Size;

import java.util.List;

public interface SizeService {
    Size createSize(Size size);
    List<Size> getAllSizes();
    Size getSizeById(Long id);
    void deleteSizeById(Long id);
    Size updateSize(Size size);
}
