package org.example.dao.impl;

import  org.example.entity.Product;
import java.util.ArrayList;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductWrapper {
    private final ArrayList<Product> products = new ArrayList<>();

    public void add(Product product) {
        products.add(product);
    }
}
