package com.trevorbye.service;

import com.trevorbye.model.CustomerUserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface CustomerUserEntityService extends UserDetailsService {

    CustomerUserEntity save(CustomerUserEntity entity);
    void delete(CustomerUserEntity entity);
    CustomerUserEntity findByUserId(long userId);
    CustomerUserEntity findByUsername(String username);
}
