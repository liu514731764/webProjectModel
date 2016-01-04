package com.liuping.user.service.impl;

import com.liuping.base.dao.EntityDao;
import com.liuping.base.service.impl.BaseServiceImpl;
import com.liuping.user.dao.UserDao;
import com.liuping.user.model.User;
import com.liuping.user.service.UserService;
import com.liuping.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by liuping on 15/12/8.
 */
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User,String> implements UserService {


    @Autowired
    private UserDao userDao;

    @Override
    protected EntityDao<User, String> getEntityDao() {
        return this.userDao;
    }

    public List<UserVo> findList(String userId) {
        return this.userDao.findList(userId);
    }

}
