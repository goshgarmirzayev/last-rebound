package com.goshgarmirzayev.lastrebound.service.impl;

import com.goshgarmirzayev.lastrebound.dao.TagDataInter;
import com.goshgarmirzayev.lastrebound.entity.Tag;
import org.springframework.stereotype.Service;

import java.util.List;

import com.goshgarmirzayev.lastrebound.service.inter.TagServiceInter;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class TagServiceImpl implements TagServiceInter {

    @Autowired
    TagDataInter aTagDaoInter;

    @Override
    public List<Tag> findAll() {
        return (List<Tag>) aTagDaoInter.findAll();
    }

    @Override
    public Tag findById(Integer id) {
        return aTagDaoInter.findById(id).get();
    }

    @Override
    public Tag save(Tag vTag) {
        return aTagDaoInter.save(vTag);
    }

    @Override
    public int deleteById(Integer id) {
        aTagDaoInter.deleteById(id);
        return 0;
    }
}