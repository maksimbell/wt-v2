package service;

import entity.*;
import java.util.Comparator;
import lombok.RequiredArgsConstructor;
import storage.ProductStorage;

@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductStorage productRepository;

    @Override
    public Product getCheapestProduct() {
        var products = productRepository.findAll();
        return products.stream().min(Comparator.comparingInt(Product::getPrice)).orElse(null);
    }
}