package com.leolee.metadataplatform.dao;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * Created by panxiaobai on 20/08/2017.
 */
@NoRepositoryBean
interface BaseRepository<T, ID extends Serializable> extends Repository<T, ID> {

    void delete(T deleted);

    List<T> findAll();

    Optional<T> findOne(ID id);

    T save(T persisted);
}
