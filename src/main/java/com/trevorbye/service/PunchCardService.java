package com.trevorbye.service;

import com.trevorbye.model.PunchCardEntity;

import java.util.List;

public interface PunchCardService {
    PunchCardEntity createOrUpdate(PunchCardEntity entity);
    PunchCardEntity selectById(long cardId);
    List<PunchCardEntity> selectAllByCompanyId(long companyId);
    void deleteEntity(PunchCardEntity entity);
    void deleteAll();
    List<PunchCardEntity> findAll();
}
