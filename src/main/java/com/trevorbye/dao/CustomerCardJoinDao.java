package com.trevorbye.dao;

import com.trevorbye.model.CustomerCardJoinEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerCardJoinDao extends CrudRepository<CustomerCardJoinEntity, Long> {

    @SuppressWarnings("unchecked")
    CustomerCardJoinEntity save(CustomerCardJoinEntity entity);

    void deleteAll();

    CustomerCardJoinEntity deleteByUserIdAndCardId(long userId, long cardId);

    List<CustomerCardJoinEntity> findAllByUserId(long userId);

    CustomerCardJoinEntity findByUserIdAndCardId(long userId, long cardId);
}
