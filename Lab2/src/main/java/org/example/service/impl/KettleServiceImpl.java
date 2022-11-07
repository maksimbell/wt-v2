package org.example.service.impl;

import org.example.entity.Kettle;
import org.example.storage.KettleStorage;
import org.example.service.KettleService;
import java.util.List;
import lombok.RequiredArgsConstructor;

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
