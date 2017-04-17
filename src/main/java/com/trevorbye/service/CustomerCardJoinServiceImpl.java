package com.trevorbye.service;

import com.trevorbye.dao.CustomerCardJoinDao;
import com.trevorbye.model.CustomerCardJoinEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerCardJoinServiceImpl implements CustomerCardJoinService {

    @Autowired
    private CustomerCardJoinDao dao;

    @Override
    public CustomerCardJoinEntity createOrUpdate(CustomerCardJoinEntity entity) {
        return dao.save(entity);
    }

    @Override
    public void deleteAll() {
        dao.deleteAll();
    }

    @Override
    public CustomerCardJoinEntity deleteUserAndCardSubscriptionCombination(long userId, long cardId) {
        return dao.deleteByUserIdAndCardId(userId,cardId);
    }

    @Override
    public List<CustomerCardJoinEntity> getAllSubscriptionsForUser(long userId) {
        return dao.findAllByUserId(userId);
    }

    @Override
    public CustomerCardJoinEntity getUserAndCardSubscription(long userId, long cardId) {
        return dao.findByUserIdAndCardId(userId, cardId);
    }
}
