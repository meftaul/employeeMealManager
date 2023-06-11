package com.meftaul.emm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmmService<T, ID> {
    T save(T t);
    Page<T> getList(Pageable page);
    T getById(ID id);
    T update(T t);
    void delete(ID id);
}

