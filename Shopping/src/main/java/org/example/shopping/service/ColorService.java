package org.example.shopping.service;

import org.example.shopping.model.Color;

import java.util.List;

public interface ColorService {
    Color createColor(Color color);

    List<Color> getAllColors();

    Color getColorById(Long id);

    void deleteColorById(Long id);

    Color updateColor(Color color);
}
