package service;

import entity.*;
import java.util.List;
import lombok.RequiredArgsConstructor;
import storage.KettleStorage;

@RequiredArgsConstructor
public class KettleServiceImpl implements KettleService {

    private final KettleStorage kettleRepository;

    @Override
    public List<Kettle> getAll() {
        return kettleRepository.findAll();
    }

    @Override
    public List<Kettle> getAllByColor(String color) {
        return kettleRepository.findAllByColor(color);
    }
}