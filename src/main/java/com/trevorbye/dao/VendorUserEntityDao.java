package com.trevorbye.dao;

import com.trevorbye.model.VendorUserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorUserEntityDao extends CrudRepository<VendorUserEntity, Long> {

    @SuppressWarnings("unchecked")
    VendorUserEntity save(VendorUserEntity entity);

    VendorUserEntity findByUsername(String username);

    void delete(VendorUserEntity entity);

    VendorUserEntity findByUserId(long userId);
}
