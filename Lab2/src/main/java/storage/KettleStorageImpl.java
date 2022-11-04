package storage;

import dao.*;
import entity.*;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class KettleStorageImpl implements KettleStorage {
    private final ProductDAO productDAO;

    @Override
    public List<Kettle> findAll() {
        var kettleCriteria = new Criteria(Kettle.class.getSimpleName());
        try {
            return productDAO.find(kettleCriteria).stream().map(Kettle.class::cast).toList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    @Override
    public List<Kettle> findAllByColor(String color) {
        var kettleCriteria = new Criteria(Kettle.class.getSimpleName());
        kettleCriteria.add("color", color);
        try {
            return productDAO.find(kettleCriteria).stream().map(Kettle.class::cast).toList();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}