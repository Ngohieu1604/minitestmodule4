package com.codegym.repository;

import com.codegym.model.Guitar;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Transactional

public class GuitarRepository implements IGuitarRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Guitar> findAll() {
        String sql = "SELECT p from Guitar p";
        TypedQuery<Guitar> query = entityManager.createQuery(sql, Guitar.class);
        return query.getResultList();
    }

    @Override
    public Guitar findById(int id) {
        String sql = "SELECT p from Guitar p where p.id = :id";
        TypedQuery<Guitar> query = entityManager.createQuery(sql, Guitar.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public boolean insert(Guitar guitar) {
        String sql = "CALL Insert_Product(:name,:price,:img);";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("name", guitar.getName());
        query.setParameter("price", guitar.getPrice());
        query.setParameter("img", guitar.getImg());
        return query.executeUpdate() == 0;
    }

    @Override
    public void remove(int id) {
        Guitar guitar = findById(id);
        if(guitar !=null){
            entityManager.remove(guitar);
        }
    }

    @Override
    public boolean update(Guitar guitar) {
        String sql = "CALL Update_Product(:name,:price,:img ,:id);";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("name", guitar.getName());
        query.setParameter("price", guitar.getPrice());
        query.setParameter("img", guitar.getImg());
        query.setParameter("id", guitar.getId());
        return query.executeUpdate() == 0;
    }
}
