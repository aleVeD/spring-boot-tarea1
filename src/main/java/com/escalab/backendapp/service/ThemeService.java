package com.escalab.backendapp.service;

import com.escalab.backendapp.model.Book;

import java.util.List;

public interface ThemeService<T, O> {
    List<T> getAll();

    T save(T obj);

    T findById(O id);

    T update(T obj);

    Boolean delete(O id);
}
