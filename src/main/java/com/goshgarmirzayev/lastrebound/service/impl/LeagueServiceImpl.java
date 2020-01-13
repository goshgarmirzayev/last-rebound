package com.goshgarmirzayev.lastrebound.service.impl;

import com.goshgarmirzayev.lastrebound.dao.LeagueDataInter;
import com.goshgarmirzayev.lastrebound.entity.League;
import com.goshgarmirzayev.lastrebound.service.inter.LeagueServiceInter;
import com.goshgarmirzayev.lastrebound.service.inter.MatchServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeagueServiceImpl implements LeagueServiceInter {
    @Autowired
    LeagueDataInter leagueDataInter;
    @Autowired
    MatchServiceInter matchServiceInter;

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
        matchServiceInter.deleteAllByLeagueId(leagueDataInter.findById(id).get());
        leagueDataInter.deleteById(id);
        return 0;
    }

    @Override
    public int deleteAll() {
        leagueDataInter.deleteAll();
        return 0;
    }

    @Override
    public League save(League league) {
        return leagueDataInter.save(league);
    }

    @Override
    public League findByName(String name) {
        return leagueDataInter.findByName(name);
    }
}
