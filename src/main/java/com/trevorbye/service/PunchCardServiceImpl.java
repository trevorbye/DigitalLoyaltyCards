package com.trevorbye.service;

import com.trevorbye.dao.PunchCardDao;
import com.trevorbye.model.PunchCardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PunchCardServiceImpl implements PunchCardService {

    @Autowired
    private PunchCardDao punchCardDao;

    @Override
    public PunchCardEntity createOrUpdate(PunchCardEntity entity) {
        return punchCardDao.save(entity);
    }

    @Override
    public PunchCardEntity selectById(long cardId) {
        return punchCardDao.findOne(cardId);
    }

    @Override
    public List<PunchCardEntity> selectAllByCompanyId(long companyId) {
        return punchCardDao.findAllByCompanyId(companyId);
    }

    @Override
    public PunchCardEntity deleteById(long cardId) {
        return punchCardDao.deleteByCardId(cardId);
    }

    @Override
    public void deleteAll() {
        punchCardDao.deleteAll();
    }
}
