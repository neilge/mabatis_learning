package com.neilge.dao;

import com.neilge.domain.User;

import java.util.List;

/**
 * @author Neo
 * @since 09/26/2020-11:49 AM
 */
public interface UserDao {
    List<User> findAll();
}
