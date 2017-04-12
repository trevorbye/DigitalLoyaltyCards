package com.trevorbye.service;

import com.trevorbye.dao.UserCardJoinDao;
import com.trevorbye.model.UserCardJoinEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserCardJoinServiceImpl implements UserCardJoinService {

    @Autowired
    private UserCardJoinDao dao;

    @Override
    public UserCardJoinEntity createOrUpdate(UserCardJoinEntity entity) {
        return dao.save(entity);
    }

    @Override
    public void deleteAll() {
        dao.deleteAll();
    }

    @Override
    public UserCardJoinEntity deleteUserAndCardSubscriptionCombination(long userId, long cardId) {
        return dao.deleteByUserIdAndCardId(userId, cardId);
    }

    @Override
    public List<UserCardJoinEntity> getAllSubscriptionsForUser(long userId) {
        return dao.findAllByUserId(userId);
    }

    @Override
    public UserCardJoinEntity getUserAndCardSubscription(long userId, long cardId) {
        return dao.findByUserIdAndCardId(userId, cardId);
    }
}
