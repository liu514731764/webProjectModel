package com.liuping.base.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by liuping on 15/12/25.
 */
public interface EntityDao <T,PK extends Serializable> {
    
     List<?> findJdbc(String sql, Object[] args, Class<?> cls);

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
