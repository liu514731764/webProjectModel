package com.liuping.base.dao.impl;

import com.liuping.base.dao.EntityDao;
import com.liuping.util.HibernateResultToBeanListUtil;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * Created by liuping on 15/12/25.
 */
public abstract class BaseHibernateDao <T,PK extends Serializable> implements EntityDao<T,PK> {

    public abstract Class<T> getEntityClass();

    @Autowired
    private SessionFactory sessionFactory;

    public Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    public List<?> findJdbc(String sql, Object[] args, Class<?> cls) {
        Query query = this.getSession().createSQLQuery(sql);
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        for (int i = 0; i < args.length; i++) {
            query.setParameter(i,args[i]);
        }

        List<?> list = HibernateResultToBeanListUtil.convertMapToBeanList(query.list(),cls);
        return  list;
    }

    public T findByPk(Serializable PK) {
        return (T)this.getSession().get(this.getEntityClass(),PK);
    }

    public void delete(Serializable PK) {
        T entity = this.findByPk(PK);
        this.delete(entity);
    }

    public void delete(T entity) {
        this.getSession().delete(entity);
    }

    public void update(T entity) {
        this.getSession().update(entity);
    }

    public <T> List<T> findAll() {
        return this.getSession().createCriteria(this.getEntityClass()).list();
    }

    public T save(T entity) {
        this.getSession().save(entity);
        return entity;
    }

    public T findOneByProperty(String propertyName, Object propertyValue) {
        Criteria criteria = this.getSession().createCriteria(this.getEntityClass());
        criteria.add(Restrictions.eq(propertyName,propertyValue));
        return (T)criteria.uniqueResult();
    }

    public <T> List<T> findByProperty(String propertyName, Object propertyValue) {
        Criteria criteria = this.getSession().createCriteria(this.getEntityClass());
        criteria.add(Restrictions.eq(propertyName,propertyValue));
        return criteria.list();
    }

    public T findOneByHql(String hql, Object... values) {
        Query query = this.getSession().createQuery(hql);
        int i = 0;
        for (Object obj: values
             ) {
            query.setParameter(i++,obj);
        }
        return (T)query.uniqueResult();
    }

    public <T> List<T> findByHql(String hql, Object... values) {
        Query query = this.getSession().createQuery(hql);
        int i = 0;
        for (Object obj: values
                ) {
            query.setParameter(i++,obj);
        }
        return query.list();
    }
}
