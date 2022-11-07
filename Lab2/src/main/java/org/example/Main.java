package org.example;

import org.example.dao.impl.ProductDAOImpl;
import org.example.storage.impl.KettleStorageImpl;
import org.example.storage.impl.ProductStorageImpl;
import org.example.service.impl.KettleServiceImpl;
import org.example.service.impl.ProductServiceImpl;

public class Main {

    public static void main(String[] args) {
        var productService = new ProductServiceImpl(new ProductStorageImpl(new ProductDAOImpl()));
        var kettleService = new KettleServiceImpl(new KettleStorageImpl(new ProductDAOImpl()));

        System.out.println(productService.getCheapestOne().toString());
        System.out.println("----------------------------------------");
        kettleService.getAll().forEach(k -> System.out.println(k.toString()));
    }
}
