package com.trevorbye.service;

import com.trevorbye.model.CustomerCardJoinEntity;

import java.util.List;

public interface CustomerCardJoinService {
    CustomerCardJoinEntity createOrUpdate(CustomerCardJoinEntity entity);
    void deleteAll();
    CustomerCardJoinEntity deleteUserAndCardSubscriptionCombination(long userId, long cardId);
    List<CustomerCardJoinEntity> getAllSubscriptionsForUser(long userId);
    CustomerCardJoinEntity getUserAndCardSubscription(long userId, long cardId);
}
