package com.neilge.dao;

import com.neilge.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Neo
 * @since 09/26/2020-11:49 AM
 */
public interface UserDao {

    @Select("select * from user")
    List<User> findAll();
}
