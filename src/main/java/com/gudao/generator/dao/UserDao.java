package com.gudao.generator.dao;

import com.gudao.generator.model.User;
import java.util.List;

public interface UserDao {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    User selectByPrimaryKey(Long id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}