package com.trevorbye.service;

import com.trevorbye.model.UserCardJoinEntity;

import java.util.List;

public interface UserCardJoinService {
    UserCardJoinEntity createOrUpdate(UserCardJoinEntity entity);
    void deleteAll();
    UserCardJoinEntity deleteUserAndCardSubscriptionCombination(long userId, long cardId);
    List<UserCardJoinEntity> getAllSubscriptionsForUser(long userId);
}
