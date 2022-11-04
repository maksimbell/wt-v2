package dao;

import static java.util.stream.Collectors.toList;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import entity.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductDaoImpl implements ProductDAO {
    private static final String PATH = "C:\\Users\\maksimbell\\bsuir\\5sem\\wt\\labs\\Lab2\\data/xml";

    @Override
    public List<Product> find(Criteria criteria) {
        try (var fileInputStream = new FileInputStream(PATH)) {

            var mapper = new XmlMapper();
            var xmlString = new String(fileInputStream.readAllBytes());
            var products = mapper.readValue(xmlString, ProductWrapper.class).getProducts();

            List<Product> concreteProducts;
            var searchingEntity = criteria.getGroupSearchName();

            if (searchingEntity.equals("")) {
                concreteProducts = products;
            } else {
                concreteProducts = products.stream().filter(
                        product -> product.getClass().getSimpleName().equals(searchingEntity)
                ).toList();
            }

            var criteriaMap = criteria.getCriteriaMap();
            var result = new ArrayList<Product>();
            if (criteriaMap.isEmpty()) {
                return concreteProducts;
            } else {
                criteriaMap.forEach((key, value) -> result.addAll(
                        concreteProducts.stream().filter(p -> {
                            try {
                                var field = p.getClass().getDeclaredField(key);
                                field.setAccessible(true);
                                return field.get(p).equals(value);
                            } catch (NoSuchFieldException | IllegalAccessException e) {
                                throw new RuntimeException(e);
                            }
                        }).toList()
                ));
            }
            return result;
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public void create(Product product) {
        try (var fileOutputStream = new FileOutputStream(PATH);) {
            var mapper = new XmlMapper();
            var url = new File(PATH).toURI().toURL();
            var productWrapper = mapper.readValue(url, ProductWrapper.class);
            productWrapper.add(product);
            fileOutputStream.write(mapper.writeValueAsBytes(productWrapper));
        } catch (IOException e) {

        }
    }
}
