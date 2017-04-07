package com.trevorbye.dao;

import com.trevorbye.model.PunchCardEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PunchCardDao extends CrudRepository<PunchCardEntity, Long> {

    @SuppressWarnings("unchecked")
    PunchCardEntity save(PunchCardEntity entity);

    PunchCardEntity findOne(long cardId);

    List<PunchCardEntity> findAllByCompanyId(long companyId);

    @Transactional
    PunchCardEntity deleteByCardId(long cardId);

    void deleteAll();

}
