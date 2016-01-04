package com.liuping.user.service;

import com.liuping.base.service.BaseService;
import com.liuping.user.model.User;
import com.liuping.user.vo.UserVo;

import java.util.List;

/**
 * Created by liuping on 15/12/8.
 */
public interface UserService extends BaseService<User,String> {

    List<UserVo> findList(String userId);
}
