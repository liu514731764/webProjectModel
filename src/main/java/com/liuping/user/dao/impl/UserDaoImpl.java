package com.liuping.user.dao.impl;

import com.liuping.base.dao.impl.BaseHibernateDao;
import com.liuping.user.dao.UserDao;
import com.liuping.user.model.User;
import com.liuping.user.vo.UserVo;
import com.liuping.util.SqlBuffer;
import com.liuping.util.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by liuping on 15/12/8.
 */
@Repository
public class UserDaoImpl extends BaseHibernateDao<User,String> implements UserDao {

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }



    public List<UserVo> findList(String userId) {
        SqlBuffer sql = new SqlBuffer();
        sql.append("SELECT u.*,CITY_NAME from `user` u join geo_city on u.USER_CITY_ID =geo_city.CITY_ID ");
        sql.append("WHERE 1=1 ");
        List<Object> paramList = new ArrayList<Object>();
        if (!StringUtils.isNullOrEmpty(userId)) {
            sql.append("AND u.USER_ID = ? ");
            paramList.add(userId);
        }

        sql.append("ORDER BY u.CREATE_TIME DESC ");
        String executeSql = sql.toString();
        List<UserVo> list = (List<UserVo>) this.findJdbc(executeSql, paramList.toArray(),
                UserVo.class);
        return list;
    }
}
