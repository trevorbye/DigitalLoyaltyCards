package com.trevorbye.dao;

import com.trevorbye.model.UserCardJoinEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCardJoinDao extends CrudRepository<UserCardJoinEntity, Long> {

    @SuppressWarnings("unchecked")
    UserCardJoinEntity save(UserCardJoinEntity entity);

    void deleteAll();

    UserCardJoinEntity deleteByUserIdAndCardId(long userId, long cardId);

    List<UserCardJoinEntity> findAllByUserId(long userId);

    UserCardJoinEntity findByUserIdAndCardId(long userId, long cardId);
}
