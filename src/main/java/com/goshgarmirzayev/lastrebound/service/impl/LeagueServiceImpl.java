package com.goshgarmirzayev.lastrebound.service.impl;

import com.goshgarmirzayev.lastrebound.dao.LeagueDataInter;
import com.goshgarmirzayev.lastrebound.entity.League;
import com.goshgarmirzayev.lastrebound.service.inter.LeagueServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LeagueServiceImpl implements LeagueServiceInter {
    @Autowired
    LeagueDataInter leagueDataInter;

    @Override
    public List<League> getAll() {
        return (List<League>) leagueDataInter.findAll();
    }

    @Override
    public League findById(Integer id) {
        return leagueDataInter.findById(id).get();
    }

    @Override
    public int deleteById(Integer id) {
        leagueDataInter.deleteById(id);
        return 0;
    }

    @Override
    public int deleteAll() {
        leagueDataInter.deleteAll();
        return 0;
    }

    @Override
    public League findByName(String name) {
        return leagueDataInter.findByName(name);
    }
}
