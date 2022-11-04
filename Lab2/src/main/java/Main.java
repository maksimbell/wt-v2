import dao.*;
import entity.Product;
import service.*;
import storage.*;

public class Main {
    public static void main(String[] args) {
        var productService = new ProductServiceImpl(new ProductStorageImpl(new ProductDaoImpl()));
        var kettleService = new KettleServiceImpl(new KettleStorageImpl(new ProductDaoImpl()));

        System.out.println(productService.getCheapestProduct().toString());
        kettleService.getAll().forEach(k -> System.out.println(k.toString()));
    }
}