package com.liuping.base.service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by liuping on 15/12/25.
 */
public interface BaseService <T,PK extends Serializable>{

    T findByPk(Serializable PK);

    void delete(Serializable PK);

    void delete(T entity);

    void update(T entity);

    <T> List<T> findAll();

    T save(T entity);

    T findOneByProperty(String propertyName, Object propertyValue);

    <T> List<T> findByProperty(String propertyName, Object propertyValue);

    T findOneByHql(String hql, Object... values);

    <T> List<T> findByHql(String hql, Object... values);
}
