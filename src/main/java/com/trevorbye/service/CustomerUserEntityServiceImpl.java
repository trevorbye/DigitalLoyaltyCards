package com.trevorbye.service;

import com.trevorbye.dao.CustomerUserEntityDao;
import com.trevorbye.model.CustomerUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerUserEntityServiceImpl implements CustomerUserEntityService {

    @Autowired
    private CustomerUserEntityDao entityDao;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return entityDao.findByUsername(username);
    }

    @Override
    public CustomerUserEntity save(CustomerUserEntity entity) {
        entity.setPassword(encoder.encode(entity.getPassword()));
        return entityDao.save(entity);
    }

    @Override
    public void delete(CustomerUserEntity entity) {
        entityDao.delete(entity);
    }

    @Override
    public CustomerUserEntity findByUserId(long userId) {
        return entityDao.findByUserId(userId);
    }

    @Override
    public CustomerUserEntity findByUsername(String username) {
        return entityDao.findByUsername(username);
    }
}
