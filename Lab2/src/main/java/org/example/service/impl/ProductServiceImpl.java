package org.example.service.impl;

import org.example.entity.Product;
import org.example.storage.ProductStorage;
import org.example.service.ProductService;
import java.util.Comparator;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductStorage productRepository;

    @Override
    public Product getCheapestOne() {
        var products = productRepository.findAll();
        return products.stream().min(Comparator.comparingInt(Product::getPrice)).orElse(null);
    }
}
