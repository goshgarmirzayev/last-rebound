package com.goshgarmirzayev.lastrebound.service.impl;

import com.goshgarmirzayev.lastrebound.dao.LinkDaoInter;
import com.goshgarmirzayev.lastrebound.entity.Link;
import com.goshgarmirzayev.lastrebound.entity.Match;
import com.goshgarmirzayev.lastrebound.service.inter.LinkServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkServiceImpl implements LinkServiceInter {
    @Autowired
    LinkDaoInter linkDaoInter;

    @Override
    public List<Link> findAll() {
        return (List<Link>) linkDaoInter.findAll();
    }

    @Override
    public Link findById(Integer id) {
        return linkDaoInter.findById(id).get();
    }

    @Override
    public Link save(Link link) {
        return linkDaoInter.save(link);
    }

    @Override
    public int deleteById(Integer id) {
        linkDaoInter.deleteById(id);
        return 0;
    }

    @Override
    public void deleteAllByMatchId(Match id) {
        linkDaoInter.deleteAllByMatchId(id);
    }

}
