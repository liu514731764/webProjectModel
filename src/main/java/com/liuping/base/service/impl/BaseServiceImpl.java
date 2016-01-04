package com.liuping.base.service.impl;

import com.liuping.base.dao.EntityDao;
import com.liuping.base.service.BaseService;

import java.io.Serializable;
import java.util.List;

/**
 * Created by liuping on 15/12/25.
 */
public abstract class BaseServiceImpl <T,PK extends Serializable> implements BaseService<T,PK> {

    protected abstract EntityDao<T, PK> getEntityDao();

    public T findByPk(Serializable PK) {
        return this.getEntityDao().findByPk(PK);
    }

    public void delete(Serializable PK) {
        this.getEntityDao().delete(PK);
    }

    public void delete(T entity) {
        this.getEntityDao().delete(entity);
    }

    public void update(T entity) {
        this.getEntityDao().update(entity);
    }

    public <T1> List<T1> findAll() {
        return this.getEntityDao().findAll();
    }

    public T save(T entity) {
        return this.getEntityDao().save(entity);
    }

    public T findOneByProperty(String propertyName, Object propertyValue) {
        return this.getEntityDao().findOneByProperty(propertyName,propertyValue);
    }

    public <T1> List<T1> findByProperty(String propertyName, Object propertyValue) {
        return this.getEntityDao().findByProperty(propertyName,propertyValue);
    }

    public T findOneByHql(String hql, Object... values) {
        return this.getEntityDao().findOneByHql(hql,values);
    }

    public <T1> List<T1> findByHql(String hql, Object... values) {
        return this.getEntityDao().findByHql(hql,values);
    }
}
