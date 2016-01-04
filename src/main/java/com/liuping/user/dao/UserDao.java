package com.liuping.user.dao;

import com.liuping.base.dao.EntityDao;
import com.liuping.user.model.User;
import com.liuping.user.vo.UserVo;

import java.util.List;

/**
 * Created by liuping on 15/12/8.
 */
public interface UserDao extends EntityDao<User,String> {

    List<UserVo> findList(String userId);
}
