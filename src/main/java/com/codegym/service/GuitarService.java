package com.codegym.service;

import com.codegym.model.Guitar;
import com.codegym.repository.IGuitarRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GuitarService implements IGuitarService{

    @Autowired
    private IGuitarRepository guitarRepository;

    @Override
    public List<Guitar> findAll() {
        return guitarRepository.findAll();
    }

    @Override
    public Guitar findById(int id) {
        return guitarRepository.findById(id);
    }

    @Override
    public boolean insert(Guitar guitar) {
        return guitarRepository.insert(guitar);
    }

    @Override
    public void remove(int id) {
        guitarRepository.remove(id);
    }

    @Override
    public boolean update(Guitar guitar) {
        return guitarRepository.update(guitar);
    }
}
