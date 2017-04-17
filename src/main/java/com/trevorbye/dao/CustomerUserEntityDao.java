package com.trevorbye.dao;

import com.trevorbye.model.CustomerUserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerUserEntityDao extends CrudRepository<CustomerUserEntity, Long> {

    @SuppressWarnings("unchecked")
    CustomerUserEntity save(CustomerUserEntity entity);

    CustomerUserEntity findByUsername(String username);

    void delete(CustomerUserEntity entity);

    CustomerUserEntity findByUserId(long userId);
}
