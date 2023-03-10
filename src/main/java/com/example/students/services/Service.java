package com.example.students.services;

public interface Service<T> {
    T save(T entity);

    void delete(T entity);

    T findById(String id);

    Iterable<T> findAll();
}
