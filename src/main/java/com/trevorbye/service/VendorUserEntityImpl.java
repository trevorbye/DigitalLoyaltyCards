package com.trevorbye.service;

import com.trevorbye.dao.VendorUserEntityDao;
import com.trevorbye.model.VendorUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class VendorUserEntityImpl implements VendorUserEntityService {

    @Autowired
    private VendorUserEntityDao vendorDao;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public VendorUserEntity save(VendorUserEntity entity) {
        entity.setPassword(encoder.encode(entity.getPassword()));
        return vendorDao.save(entity);
    }

    @Override
    public void delete(VendorUserEntity entity) {
        vendorDao.delete(entity);
    }

    @Override
    public VendorUserEntity findByUserId(long userId) {
        return vendorDao.findByUserId(userId);
    }

    @Override
    public VendorUserEntity findByUsername(String username) {
        return vendorDao.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return vendorDao.findByUsername(username);
    }
}
