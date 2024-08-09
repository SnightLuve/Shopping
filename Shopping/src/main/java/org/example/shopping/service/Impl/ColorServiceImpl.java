package org.example.shopping.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.shopping.model.Color;
import org.example.shopping.repository.ColorRepository;
import org.example.shopping.service.ColorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ColorServiceImpl implements ColorService {
    private final ColorRepository colorRepository;
    @Override
    public Color createColor(Color color) {
        return colorRepository.save(color);
    }

    @Override
    public List<Color> getAllColors() {
        return colorRepository.findAll();
    }

    @Override
    public Color getColorById(Long id) {
        return colorRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteColorById(Long id) {
        colorRepository.removeById(id);
    }

    @Override
    public Color updateColor(Color color) {
        Color c = colorRepository.findById(color.getId()).orElse(null);
        return colorRepository.save(c);
    }
}
