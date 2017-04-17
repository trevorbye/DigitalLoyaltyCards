package com.trevorbye.service;

import com.trevorbye.model.VendorUserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface VendorUserEntityService extends UserDetailsService {
    VendorUserEntity save(VendorUserEntity entity);
    void delete(VendorUserEntity entity);
    VendorUserEntity findByUserId(long userId);
    VendorUserEntity findByUsername(String username);
}
