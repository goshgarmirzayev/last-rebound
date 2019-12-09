package com.goshgarmirzayev.lastrebound.service.impl;

import com.goshgarmirzayev.lastrebound.dao.SupportDaoInter;
import com.goshgarmirzayev.lastrebound.entity.Support;
import com.goshgarmirzayev.lastrebound.service.inter.SupportServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupportServiceImpl implements SupportServiceInter {
    @Autowired
    SupportDaoInter supportDaoInter;

    @Override
    public List<Support> findAll() {
        return (List<Support>) supportDaoInter.findAll();
    }

    @Override
    public Support findById(Integer id) {
        return supportDaoInter.findById(id).get();
    }

    @Override
    public Support save(Support support) {
        return supportDaoInter.save(support);
    }

    @Override
    public Support update(Support support) {
        return supportDaoInter.save(support);
    }

    @Override
    public void deleteById(Integer id) {
        supportDaoInter.deleteById(id);
    }
}
